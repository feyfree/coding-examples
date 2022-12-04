package com.feyfree.work.scatter;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 权重打散
 *
 * @author leilei
 */
public class WeightScatter {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class Text {
        int id;
        Product product;
        double score;
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class Product {
        int item;
        String category;
        String brand;
    }

    public static void main(String[] args) {
        // 商品列表
        Product[] products = new Product[]{
                Product.builder().item(1).category("洗护").brand("宝洁").build(),
                Product.builder().item(2).category("洗护").brand("联合利华").build(),
                Product.builder().item(3).category("家具").brand("顾家").build(),
                Product.builder().item(4).category("家具").brand("林氏木业").build(),
                Product.builder().item(5).category("家具").brand("源氏物语").build(),
                Product.builder().item(6).category("家具").brand("索菲亚").build(),
                Product.builder().item(7).category("电脑").brand("戴尔").build(),
                Product.builder().item(8).category("电脑").brand("联想").build(),
                Product.builder().item(9).category("电脑").brand("三星").build(),
                Product.builder().item(10).category("电脑").brand("LG").build(),
                Product.builder().item(11).category("电脑").brand("惠普").build(),
                Product.builder().item(12).category("牛奶").brand("蒙牛").build(),
                Product.builder().item(13).category("牛奶").brand("伊利").build(),
                Product.builder().item(14).category("牛奶").brand("光明").build(),
                Product.builder().item(15).category("牛奶").brand("卫岗").build(),
                Product.builder().item(16).category("汽车").brand("领克").build(),
                Product.builder().item(17).category("汽车").brand("保时捷").build(),
                Product.builder().item(18).category("汽车").brand("宝马").build(),
                Product.builder().item(19).category("汽车").brand("特斯拉").build(),
                Product.builder().item(20).category("汽车").brand("比亚迪").build()};
        // 随机视频
        List<Text> texts = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            long mod = Math.abs(new Random().nextInt(Integer.MAX_VALUE)) % products.length;
            Text text = Text.builder().id(i + 10000)
                    .product(products[(int) mod])
                    .score(new Random().nextDouble())
                    .build();
            texts.add(text);
        }
        // 商品
        double itemW = 10;
        // 分类
        double categoryW = 5;
        // 品牌
        double brandW = 5;
        // 预先处理score
        texts.sort((o1, o2) -> Double.compare(o2.getScore(), o1.getScore()));
        Map<Integer, Text> previous = texts.stream().collect(Collectors.toMap(Text::getId, text -> text));
        System.out.println("排序前:" + JSONObject.toJSONString(texts, SerializerFeature.DisableCircularReferenceDetect));

        Map<Integer, Integer> itemMap = new HashMap<>();
        Map<String, Integer> categoryMap = new HashMap<>();
        Map<String, Integer> brandMap = new HashMap<>();
        for (Text text : texts) {
            Product product = text.getProduct();
            String brand = product.getBrand();
            String category = product.getCategory();
            int item = product.getItem();
            Integer itemCount = itemMap.getOrDefault(item, 0);
            Integer brandCount = brandMap.getOrDefault(brand, 0);
            Integer categoryCount = categoryMap.getOrDefault(category, 0);
            text.setScore(itemW * itemCount + brandCount * brandW + categoryCount * categoryW - text.getScore());

            itemMap.put(item, itemCount + 1);
            brandMap.put(brand, brandCount + 1);
            categoryMap.put(category, categoryCount + 1);
        }
        texts.sort(Comparator.comparingDouble(Text::getScore));
        System.out.println("排序后:" + JSONObject.toJSONString(texts, SerializerFeature.DisableCircularReferenceDetect));


    }
}
