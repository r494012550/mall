package com.macro.mall;

import com.github.pagehelper.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListTest {
    @Test
    public void listTest(){
//        StringBuilder stringBuilder = new StringBuilder();
        String name = "";
        String name1= "11";
        String name2= "22";
        String name3= "33";

        List<String> stringList = new ArrayList<>();
        Map map = new HashMap<>();
        stringList.add(name1);
        stringList.add(name2);
        stringList.add(name3);

//        for (String s : stringList) {
//            stringBuilder.append(s).append("_");
//        }

//        for (String s : stringList) {
//            name+=s+"_";
//        }

        name = StringUtils.join(stringList.stream().map(String::toString).collect(Collectors.toList()), "、");
//        System.out.println(stringBuilder);
        System.out.println(name);
    }

}
