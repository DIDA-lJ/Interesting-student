package com.qiyao.pojo;


//统一响应结果

public class Result<T> {
    /**
     * 业务状态码  0-成功  1-失败
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 响应数据
     */
    private T data;

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 快速返回操作成功响应结果(带响应数据)
     */
    public static <E> Result<E> success(E data) {
        return new Result<>(0, "操作成功", data);
    }

    /**
     * 快速返回操作成功响应结果
     */
    public static Result success() {
        return new Result(0, "操作成功", null);
    }

    public static Result error(String message) {
        return new Result(1, message, null);
    }
}
