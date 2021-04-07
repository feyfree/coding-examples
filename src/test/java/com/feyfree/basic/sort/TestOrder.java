package com.feyfree.basic.sort;


import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestOrder {

    @Test
    public void testOrder() {
        CentBuyProductsActivity a = new CentBuyProductsActivity(1, 0);
        CentBuyProductsActivity b = new CentBuyProductsActivity(2, 1);
        CentBuyProductsActivity c = new CentBuyProductsActivity(3, 4);
        CentBuyProductsActivity d = new CentBuyProductsActivity(5, 6);
        List<CentBuyProductsActivity> data = new ArrayList<>();
        data.add(a);
        data.add(b);
        data.add(c);
        data.add(d);
        List<Integer> order = new ArrayList<>();
        buildOrderedList(data, order);
        System.out.println(JSONObject.toJSONString(data));

    }


    /**
     * 根据活动列表 和配置列表 返回相对顺序
     *
     * @param data  后台查询的数据
     * @param order 写在配置里面的数据
     */
    private void buildOrderedList(List<CentBuyProductsActivity> data, List<Integer> order) {
        data.sort((a, b) -> {
            int ia = order.indexOf(a.getId());
            int ib = order.indexOf(b.getId());
            if (ia == -1 && ib == -1) {
                return a.getId() - b.getId();
            } else if (ia == -1) {
                return 1;
            } else if (ib == -1) {
                return -1;
            } else {
                return ia - ib;
            }
        });
    }

}
