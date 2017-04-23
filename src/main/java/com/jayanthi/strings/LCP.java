package com.jayanthi.strings;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class LCP {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String[] strings = new String[t];
        for(int a0 = 0; a0 < t; a0++){
            strings[a0] = in.next();
        }
        System.out.println(longestCommonPrefix(strings));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (StringUtils.isEmpty(prefix)) return "";
            }
        return prefix;
    }
}
