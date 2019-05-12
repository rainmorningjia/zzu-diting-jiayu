package com.zzu.diting.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/4/26 18:35
 */
public class SplitNameAndId {
   /* public static List<String> getNameAndId(String s) {
        List<String> list = new ArrayList<>();
        char l = 40;
        char[] chars = new char[100];
        char[] charo = new char[9];
        char[] chars1 = s.toCharArray();
        int j = 0;
        int idLength = 4;
        for (int i = 0; i < chars1.length - 1; i++) {
            if (chars1[i] == l) {
                j = i;
            }
        }
        for (int i = 0; i < j; i++) {
            chars[i] = chars1[i];
        }
        int mm = 0;
        for (int i = j + idLength; i < chars1.length - 1; i++) {
            charo[mm] = chars1[i];
            mm++;
        }
        list.add(new String(chars).trim());
        list.add(new String(charo).trim());
        return list;

    }*/
}
