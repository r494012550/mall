package com.macro.mall;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateTest {

    @Test
    public void dateTest(){
        int noticeDate = 20220509;
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
//        List<String> dates = new ArrayList<>();
        String day, lastDay;
        try {
            date = df.parse("" + noticeDate);
        } catch (ParseException exception) {
            exception.printStackTrace();
        }

        Calendar cale = Calendar.getInstance();
        cale.setTime(date);

        // 获取前月的第一天

        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        day = df.format(cale.getTime());
        // 获取前月的最后一天

        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        lastDay = df.format(cale.getTime());
        System.out.println("本月第一天和最后一天分别是 ： " + day + " and " + lastDay);
    }

}
