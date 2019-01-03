package com.fang.bigdata.metadata.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static String getDays(String dayFrom, String dayTo) throws ParseException {

        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        Date dfrom = sf.parse(dayFrom);
        Date dto = sf.parse(dayTo);

        if (dfrom.getTime() > dto.getTime())
            return dayFrom + "," + dayTo;
        else if (dfrom.getTime() == dto.getTime())
            return dayFrom;

        StringBuffer sb = new StringBuffer(dayFrom);
        String daytmp = dayFrom;
        while (!dayTo.equals(daytmp)) {
            Calendar c = Calendar.getInstance();
            c.setTime(sf.parse(daytmp));
            c.add(Calendar.DAY_OF_MONTH, 1); // 今天+1天
            Date tomorrow = c.getTime();
            daytmp = sf.format(tomorrow);
            sb.append("," + daytmp);
        }
//        sb.append("," + dayTo);

        String sbstr = sb.toString();
        return sbstr;

    }

    public static void main(String[] args) throws ParseException {
        System.out.println(getDays("2018-09-09", "2018-09-05"));
    }
}
