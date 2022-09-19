package com.feyfree.others;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class StringDemo {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static void main(String[] args) throws ParseException {
        String time = "2022-08-24 15:10:48.623";
        Date date = SIMPLE_DATE_FORMAT.parse(time.substring(0, 19));
        System.out.println(date);


        Map<String, String> data = getUrlParameterMap("https://aaa.com/detail?video=&shopId=2&appCont=0&itemId=40443&limitActivityId=0&isPreview=0&isRecommend=0&discoverId=");
        System.out.println(data);
    }


    public static Map<String, String> getUrlParameterMap(String url) {
        Map<String, String> result = new HashMap<>();
        if (StringUtils.isNotEmpty(url)) {
            int index = url.indexOf("?");
            if (index > 0) {
                String[] data = url.substring(index + 1).split("&");
                if (data.length > 0) {
                    for (String one : data) {
                        String[] pair = one.split("=");
                        if (pair.length > 1) {
                            result.put(pair[0], pair[1]);
                        }
                    }
                }
            }
        }
        return result;
    }
}
