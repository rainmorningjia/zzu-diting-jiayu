package com.zzu.diting.util;

import java.util.UUID;

public class MybatisUtils {

    public static String getUUID() {
        String uuid = null;
        uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }
}
