package com.hsh.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xrkhy
 * @date 2025/9/8 21:54
 * @description
 */
@Data
public class ResultJSON<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;
    public ResultJSON(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;

    }

    /**
     * 操作成功或者失败
     * @param c 受影响行数
     * @return 当前传入的受影响行数>0则返回成功，否则返回失败
     */
    public static  ResultJSON successORerror(int c){
        return c>0?new ResultJSON(200,"操作成功",c)
                :new ResultJSON(400,"操作失败",c);
    }

    public static ResultJSON success(){
        return new ResultJSON(200,"操作成功",null);
    }
    public static ResultJSON success(String msg){
        return new ResultJSON(200,msg,null);
    }
    public static <T> ResultJSON success(T data){
        return new ResultJSON(200,"操作成功",data);
    }
    public static ResultJSON success(Integer code,String msg){
        return new ResultJSON(code,msg,null);
    }
    public static <T> ResultJSON success(String msg,T data){
        return new ResultJSON(200,msg,data);
    }
    public static <T> ResultJSON success(Integer code,String msg,T data){
        return new ResultJSON(code,msg,data);
    }

    public static ResultJSON error(){
        return new ResultJSON(500,"操作失败",null);
    }
    public static ResultJSON error(String msg){
        return new ResultJSON(500,msg,null);
    }
    public static ResultJSON error(Integer code,String msg){
        return new ResultJSON(code,msg,null);
    }
}
