package com.stan.common.model.dto;


import com.stan.common.model.IErrorCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = -1437243342614460650L;
    /**
     * 返回数据
     */
    private T content;
    /**
     * 是否成功
     */
    private boolean success = true;
    /**
     * 错误码, 0: 成功
     */
    private int code = 0;
    /**
     * 错误消息
     */
    private String msg = "success";

    public CommonResult(T data) {
        this.content = data;
    }

    public CommonResult(IErrorCode e) {
        this.success = false;
        this.code = e.getErrorCode();
        this.msg = e.getErrorMsg();
    }

    public CommonResult(int errorCode, String errorMsg) {
        this.success = false;
        this.code = errorCode;
        this.msg = errorMsg;
    }

    public static <E extends IErrorCode, S> CommonResult<S> failure(E e) {
        return new CommonResult<S>(e);
    }

    public static <S> CommonResult<S> failure(int errorCode, String errorMsg) {
        return new CommonResult<S>(errorCode, errorMsg);
    }

    public static <S> CommonResult<S> success(S data) {
        return new CommonResult<S>(data);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
