package com.feyfree.others;

import java.io.Serializable;

/**
 * 直播数据类型 枚举
 *
 * @author leilei
 */
public enum StatisticsComponentEnum implements Serializable {
    /**
     * 浏览人数
     */
    VIEW_COUNT(1, "浏览人数"),

    /**
     * 浏览次数
     */
    VIEW_TIMES(2, "浏览次数"),

    /**
     * 在线认数
     */
    ONLINE_COUNT(3, "在线人数"),

    /**
     * 平均观看时长
     */
    AVERAGE_VIEW_DURATION(4, "平均观看时长"),

    /**
     * 新增粉丝数
     */
    NEW_FANS_INCREASED(5, "新增粉丝数"),

    /**
     * 当前直播订单数
     */
    CURRENT_ORDERS(6, "订单数"),

    /**
     * 当前直播订单销售额（元）
     */
    CURRENT_SALES(7, "销售额 (元)");

    /**
     * 编号
     */
    private Integer id;

    /**
     * 描述
     */
    private String desc;

    StatisticsComponentEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "StatisticsComponentEnum{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                '}';
    }
}
