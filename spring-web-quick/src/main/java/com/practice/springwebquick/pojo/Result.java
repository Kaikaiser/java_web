package com.practice.springwebquick.pojo;

public class Result {
    private String msg;
    private Integer code;
    /**
     * 返回的数据
     */
    private Object data;

    public Result(String msg, Integer code, Object data) {
        this.data = data;
        this.msg = msg;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Result{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }

    public Result() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public static Result succes(Object o){
        return new Result("succeed", 1 , o);
    }

    public static Result error(){
        return new Result("failed", 0 , null);
    }

}
