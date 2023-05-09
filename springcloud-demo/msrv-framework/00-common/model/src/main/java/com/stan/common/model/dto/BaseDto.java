package com.stan.common.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@NoArgsConstructor
@SuperBuilder
@ToString
public class BaseDto implements Serializable {
    private static final long serialVersionUID = 1970L;

}
