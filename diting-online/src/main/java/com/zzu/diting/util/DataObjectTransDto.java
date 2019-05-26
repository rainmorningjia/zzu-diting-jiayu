package com.zzu.diting.util;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.List;
import java.util.Date;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/4 10:52
 */
public class DataObjectTransDto {
    /**
     * 将dto和entity之间的属性互相转换,dto中属性一般为String等基本类型,
     * <p>
     * 但是entity中可能有复合主键等复杂类型,需要注意同名问题
     *
     * @param src
     * @param target
     */

    public static Object populate(Object src, Object target) {

        Method[] srcMethods = src.getClass().getMethods();

        Method[] targetMethods = target.getClass().getMethods();
        for (Method m : srcMethods) {

            String srcName = m.getName();

            if (srcName.startsWith("get")) {

                try {

                    Object result = m.invoke(src);

                    for (Method mm : targetMethods) {

                        String targetName = mm.getName();
                        if (targetName.substring(3, targetName.length())
                                .equals(srcName.substring(3, srcName.length()))) {
                            if (target.getClass().getSimpleName().equals("OrganizationAuthenticationInfoPO")) {
                                String results = (String) result;
                                if (results.contains(",")) {
                                    String newS = results.split(",")[1];
                                    result = newS;
                                }
                            }
                            if (target.getClass().getSimpleName().equals("PersonalAuthenticationInfoPO")){
                                String results = (String) result;
                                if (results.contains(",")) {
                                    String newS = results.split(",")[0];
                                    result = newS;
                                }
                            }
                            if (targetName.equals("setUpdateTime")) {
                                Long t1 = (Long) result;
                                String s = DataTransformUtil.stringDateTransformLong(t1);
                                mm.invoke(target, s);
                            } else if (targetName.equals("setCreateTime")) {
                                Long t1 = (Long) result;
                                String s = DataTransformUtil.stringDateTransformLong(t1);
                                mm.invoke(target, s);
                            } else if (targetName.startsWith("set")) {
                                mm.invoke(target, result);

                            }

                        }

                    }

                } catch (Exception e) {


                }

            }

        }

        return target;

    }

    /**
     * dto集合和实体类集合间的互相属性映射
     *
     * @param src
     * @param target
     * @param targetClass
     * @return
     */

    @SuppressWarnings("unchecked")

    public static <S, T> List<T> populateList(List<S> src, List<T> target, Class<?> targetClass) {

        for (int i = 0; i < src.size(); i++) {

            try {

                Object object = targetClass.newInstance();

                target.add((T) object);

                populate(src.get(i), object);


            } catch (Exception e) {

                continue;//某个方法反射异常

            }

        }

        return target;

    }
}
