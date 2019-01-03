package com.fang.bigdata.metadata.utils;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @project:metadata
 * @packname:com.fang.bigdata.metadata.utils
 * @name: StringUtils
 * @describe:
 * @author: niujiaxin
 * @create: 2018-10-20-17:42
 */
public final class StringUtils {
    private static final String[] ILLAGAL_SQL = new String[]{" ", "\\(", "\\)", "--", ",", ";", "#"};
    private static String ILLAGAL_SQL_REG = null;

    static {
        StringBuilder sb = new StringBuilder("(");
        String[] var4 = ILLAGAL_SQL;
        int var3 = ILLAGAL_SQL.length;

        for(int var2 = 0; var2 < var3; ++var2) {
            String str = var4[var2];
            sb.append(str).append("|");
        }

        ILLAGAL_SQL_REG = sb.deleteCharAt(sb.length() - 1).append(")").toString();
    }

    private StringUtils() {
    }

    public static String getNotNullValue(String value) {
        return isNotBlank(value) ? value : "";
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static String checkValidSQL(String str) {
        if (str == null) {
            return null;
        } else {
            Pattern p = Pattern.compile(ILLAGAL_SQL_REG);
            Matcher m = p.matcher(str);
            if (m.find()) {
                //BdpLogger.error("非法sql注入");
                return null;
            } else {
                return str;
            }
        }
    }

    public static String get32UUID() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid;
    }
}