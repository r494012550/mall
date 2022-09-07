package com.macro.mall;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringTest {

    @Test
    public void stringTest(){

//        List<String> sList = new ArrayList<>();
//        sList.add("1");
//        sList.add("2");
//        sList.add("3");
//        sList.add("4");
//        sList.add("5");
//        sList.add("6");
//        sList.add("7");
        String[] str = {"1","2","3","4","5","6","7"};
        String nametext ="现在{name}要把{name}这些{name}脚本{name}集成{name}到我{name}们的{name}系统里面";
        System.out.println(Parser.parse("{name","}",nametext, str));

    }

     static class Parser {
         /**
          * 将字符串text中由openToken和closeToken组成的占位符依次替换为args数组中的值
          *
          * @param openToken
          * @param closeToken
          * @param text
          * @param args
          * @return
          */
         public static String parse(String openToken, String closeToken, String text, Object... args) {
             if (args == null || args.length <= 0) {
                 return text;
             }
             int argsIndex = 0;
             if (text == null || text.isEmpty()) {
                 return "";
             }
             char[] src = text.toCharArray();
             int offset = 0;
             // search open token
             int start = text.indexOf(openToken, offset);
             if (start == -1) {
                 return text;
             }
             final StringBuilder builder = new StringBuilder();
             StringBuilder expression = null;
             while (start > -1) {
                 if (start > 0 && src[start - 1] == '\\') {
                     // this open token is escaped. remove the backslash and continue.
                     builder.append(src, offset, start - offset - 1).append(openToken);
                     offset = start + openToken.length();
                 } else {
                     // found open token. let's search close token.
                     if (expression == null) {
                         expression = new StringBuilder();
                     } else {
                         expression.setLength(0);
                     }
                     builder.append(src, offset, start - offset);
                     offset = start + openToken.length();
                     int end = text.indexOf(closeToken, offset);
                     while (end > -1) {
                         if (end > offset && src[end - 1] == '\\') {
                             // this close token is escaped. remove the backslash and continue.
                             expression.append(src, offset, end - offset - 1).append(closeToken);
                             offset = end + closeToken.length();
                             end = text.indexOf(closeToken, offset);
                         } else {
                             expression.append(src, offset, end - offset);
                             offset = end + closeToken.length();
                             break;
                         }
                     }
                     if (end == -1) {
                         // close token was not found.
                         builder.append(src, start, src.length - start);
                         offset = src.length;
                     } else {

                         String value = (argsIndex <= args.length - 1) ?
                                 (args[argsIndex] == null ? "" : args[argsIndex].toString()) : expression.toString();
                         builder.append(value);
                         offset = end + closeToken.length();
                         argsIndex++;

                     }
                 }
                 start = text.indexOf(openToken, offset);
             }
             if (offset < src.length) {
                 builder.append(src, offset, src.length - offset);
             }
             return builder.toString();
         }

         public static String parse0(String text, Object... args) {
             return Parser.parse("${", "}", text, args);
         }

         public static String parse1(String text, Object... args) {
             return Parser.parse("{", "}", text, args);
         }
     }
}
