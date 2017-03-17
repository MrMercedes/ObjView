package com.example.hp0331.objview.activity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aaron.zhang
 * at  2017/3/17.
 */

public class Zz {
    public static void main(String[] args) {
        //查找以Java开头,任意结尾的字符串
        Pattern pattern = Pattern.compile("^Java.*");
        Matcher matcher = pattern.matcher("Java不是人");
        boolean b= matcher.matches();
//当条件满足时，将返回true，否则返回false
        System.out.println(b);


       // 以多条件分割字符串时
        Pattern pattern1 = Pattern.compile("[, |]+");
        String[] strs = pattern1.split("Java Hello World  Java,Hello,,World|Sun");
        for (int i=0;i<strs.length;i++) {
            System.out.println(strs[i]);
        }


        //文字替换（首次出现字符）
        Pattern pattern2 = Pattern.compile("正则表达式");
        Matcher matcher2 = pattern2.matcher("正则表达式 Hello World,正则表达式 Hello World");
//替换第一个符合正则的数据
        System.out.println(matcher2.replaceFirst("Java"));
//替换所有符合正则的数据
        System.out.println(matcher2.replaceAll("Java"));



        //文字替换（置换字符）
        Pattern pattern3 = Pattern.compile("正则表达");
        Matcher matcher3 = pattern3.matcher("正则表达式 Hello World,正则表达式 Hello World ");
        StringBuffer sbr = new StringBuffer();
        while (matcher3.find()) {
            matcher3.appendReplacement(sbr, "Java");
        }
        matcher3.appendTail(sbr);
        System.out.println(sbr.toString());



        //验证是否为邮箱地址
        String str="aaron.zhang@hansong-china.com";
        String str1="877253660@126.com";
        Pattern pattern4 = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher matcher4 = pattern4.matcher(str);
        System.out.println(matcher4.matches());

        Pattern pattern5=Pattern.compile("^[a-z0-9A-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$");
        Matcher matcher5=pattern5.matcher(str);
        System.out.println(matcher5.matches());



        //验证是否是手机号
        Pattern pattern6 = Pattern
                .compile("^((13[0-9])|(15[0-9])|(18[0-9])|(14[7])|(17[0|3|6|7|8]))\\d{8}$");
        Matcher  matcher6= pattern6.matcher("18977778989");
        System.out.println(matcher6.matches()+"18977778989");
    }



}
