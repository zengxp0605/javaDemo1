package com.stan.msrv.framework.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author：zengxp
 */
@Getter
@AllArgsConstructor
public enum EnumRpcError {
    RPC_REQUEST_NULL("RCP_0001", "RPC_REQUEST不能为空"),
    IDEMPOTENT_ERROR("RCP_0004", "幂等校验失败"),

    ;

    private String code;
    private String desc;
}
