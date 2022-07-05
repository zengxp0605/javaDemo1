package com.stan.jol;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ResponseDTO  {

    private static final long serialVersionUID = -1437243342614460651L;

    @Builder.Default
    private boolean success = true;

    @Builder.Default
    private Integer code = 0;

    @Builder.Default
    private String msg = "ok";


    public ResponseDTO setErrorCode(Integer code, String msg) {
        this.success = false;
        this.code = code;
        this.msg = msg;
        return this;
    }

}
