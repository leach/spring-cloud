package com.anythy.base.common.base;

import java.io.Serializable;
import java.util.List;

/**
 * 统一返回Data对象
 * @author Leach
 */
public class CommonResult<T> implements Serializable {
    /**
     * 总记录数
     */
    private int code;
    private String msg;
    private T data;

    /**
     * 成功但无返回数据
     * @return
     */
    public static CommonResult success(){
        return new CommonResult(Base.ZERO, Base.EMPTY, null);
    }
    /**
     * 返回数据
     * @param data
     * @param <M>
     * @return
     */
    public static <M> CommonResult success(M data){
        return new CommonResult<>(Base.ZERO, Base.EMPTY, data);
    }

    public static <M extends BaseObjModel> CommonResult success(M data){
        return new CommonResult<>(Base.ZERO, Base.EMPTY, data);
    }

    public static <M> CommonResult success(List<M> list){
        return new CommonResult<>(Base.ZERO, Base.EMPTY, new BaseListModel<>(list));
    }

    public static <M> CommonResult success(List<M> list, long count){
        return new CommonResult<>(Base.ZERO, Base.EMPTY, new BaseListModel<>(list, count));
    }

    public CommonResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
