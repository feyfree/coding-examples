package com.feyfree.others;

/**
 * 直播申请拒绝枚举
 *
 * @author leilei
 */
public enum LiveApplyRejectReasonEnum {
    /**
     * 0 表示其他自定义原因  1001 - 1012 为模板理由
     */
    REASON_0(0, "自定义理由"),
    REASON_1(1001, "手持身份证照片信息模糊"),
    REASON_2(1002, "姓名或证件号码与原信息不符"),
    REASON_3(1003, "非本人手持身份证拍照"),
    REASON_4(1004, "身份证已过有效期"),
    REASON_5(1005, "照片修饰过度"),
    REASON_6(1006, "申请人未满十八周岁"),
    REASON_7(1007, "身份证非原件"),
    REASON_8(1008, "申请证件非身份证"),
    REASON_9(1009, "申请人五官被遮挡"),
    REASON_10(1010, "主播申请信息不合格"),
    REASON_11(1011, "身份证信息被遮挡"),
    REASON_12(1012, "申请资料不符合要求");

    private int code;
    private String msg;

    LiveApplyRejectReasonEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static String getMsg(int code) {
        switch (code) {
            case 0:
                return REASON_0.getMsg();
            case 1001:
                return REASON_1.getMsg();
            case 1002:
                return REASON_2.getMsg();
            case 1003:
                return REASON_3.getMsg();
            case 1004:
                return REASON_4.getMsg();
            case 1005:
                return REASON_5.getMsg();
            case 1006:
                return REASON_6.getMsg();
            case 1007:
                return REASON_7.getMsg();
            case 1008:
                return REASON_8.getMsg();
            case 1009:
                return REASON_9.getMsg();
            case 1010:
                return REASON_10.getMsg();
            case 1011:
                return REASON_11.getMsg();
            case 1012:
                return REASON_12.getMsg();
            default:
                return "";
        }
    }
}
