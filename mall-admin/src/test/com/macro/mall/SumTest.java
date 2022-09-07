package com.macro.mall;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class SumTest {

    @Test
    public void sumTest(){
        double d = 123.00212131;
        String s = "123.00212131";
        DecimalFormat dft = new DecimalFormat("#.00");
        DecimalFormat dft1 = new DecimalFormat("#.000");
        System.out.println(dft.format(d));
        //数据类型错误   入参不能用String类型
        System.out.println(dft1.format(s));
    }


}
