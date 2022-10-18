package com.feyfree.basic.collections;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {


    @Data
    static class Content {
        List<String> data;
    }

    public static void main(String[] args) {
        List<String> data = new ArrayList<>(2);
        data.add("1");
        data.add("2");
        Content content = new Content();
        content.setData(data);
        data.add("3");
        data.add("4");
        data.add("5");
        data.add("6");
        data.add("7");
        data.add("8");
        System.out.println(JSONObject.toJSONString(content.getData()));
    }
}
