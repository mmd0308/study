package com.hzqing.study.strategy;

/**
 * @author hzqing
 * @date 2019-07-04 07:58
 */
public class PayRestult {

    private String code;

    private String msg;

    private Object date;

    public PayRestult(String code, String msg, Object date) {
        this.code = code;
        this.msg = msg;
        this.date = date;
    }

    @Override
    public String toString() {
        return "PayRestult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }
}
