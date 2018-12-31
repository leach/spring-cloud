package com.anythy.zkconfigserver.enums;

/**
 * 状态枚举
 * @author Leach
 */
public enum StatusEnum {
    //任务状态，100：未发布，150：待接单，200：进行中，250：待确认，300：待生成账单，350：待结算，400：已结算完成，450：平台已支付
    ENABLED(10,"启用"),
    DISABLED(20,"禁用"),
    DELETED(30,"禁用")
    ;

    private int code;
    private String value;

    StatusEnum(int code, String value ) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static String getName(int code) {
        for (StatusEnum c : StatusEnum.values()) {
            if (c.getCode() == code) {
                return c.value;
            }
        }
        return null;
    }
}
