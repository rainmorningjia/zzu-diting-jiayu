package com.zzu.diting.mapper;

import com.zzu.diting.entity.CopyrightInfoPO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author wb-jcy525678
 */
@org.apache.ibatis.annotations.Mapper
public interface CopyrightInfoMapper extends Mapper<CopyrightInfoPO> {
    /**
     * 查询固定页码的著作权信息
     *
     * @param num1
     * @param num2
     * @return
     */
    List<CopyrightInfoPO> queryCopyrightInfoList(@Param("num1") Integer num1, @Param("num2") Integer num2);
}
