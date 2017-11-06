package com.jhh.match.enums;

/**
 * 出借状态枚举类
 *
 * @author tianweichang
 * @create 2017-10-30 11:10
 **/
public enum LoanMatchStateEnum {
    ALL(5, "loanMatchAll"),//全部
    PAYMENT_FAIL(4, "loanMatchPaymentFail"),//放款失败
    PAYMENT_SUCC(3, "loanMatchPaymentSucc"),//放款成功
    MATCHED(2, "loanMatched"),//已匹配
    MATCHING(1, "loanMatching"),//匹配中
    WAIT_MATCH(0, "loanMatchWait");//待匹配
    private Integer state;
    private String value;

    LoanMatchStateEnum(Integer state, String value) {
        this.state = state;
        this.value = value;
    }

    /**
     * 获取ftl路径
     * @param state 状态
     */
    public static String getValueByState(Integer state) {
        for (LoanMatchStateEnum loanMatchStateEnum : LoanMatchStateEnum.values()) {
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
