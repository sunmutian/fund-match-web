package com.jhh.match.enums;

/**
 * 借款状态枚举类
 *
 * @author tianweichang
 * @create 2017-10-30 11:12
 **/
public enum DebitMatchStateEnum {
    ALL(4, "debitMatchAll"),//全部
    PAYMENT_FAIL(3, "debitMatchPaymentFail"),//放款失败
    PAYMENT_SUCC(2, "debitMatchPaymentSucc"),//放款成功
    MATCHED(1, "debitMatched"),//已匹配
    WAIT_MATCH(0, "debitMatchWait");//待匹配
    private Integer state;
    private String value;

    DebitMatchStateEnum(Integer state, String value) {
        this.state = state;
        this.value = value;
    }

    /**
     * 获取ftl路径
     *
     * @param state 状态
     */
    public static String getValueByState(Integer state) {
        for (DebitMatchStateEnum loanMatchStateEnum : DebitMatchStateEnum.values()) {
            if (loanMatchStateEnum.state == state) {
                return loanMatchStateEnum.value;
            }
        }
        return null;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
