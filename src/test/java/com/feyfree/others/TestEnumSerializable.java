package com.feyfree.others;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestEnumSerializable {

    @Test
    public void testEnums() {
        List<StatisticsComponentEnum> all = new ArrayList<>();
        all.add(StatisticsComponentEnum.AVERAGE_VIEW_DURATION);
        System.out.println(JSONObject.toJSONString(all));
    }

    @Test
    public void testForEachEnums() {
        for (StatisticsComponentEnum componentEnum : StatisticsComponentEnum.values()) {
            System.out.println(componentEnum);
        }
    }

    @Test
    public void testSwitchEnums() {
        System.out.println(LiveApplyRejectReasonEnum.getMsg(1012));
    }
}
