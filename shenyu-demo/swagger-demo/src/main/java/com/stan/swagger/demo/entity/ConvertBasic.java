package com.stan.swagger.demo.entity;

import com.stan.swagger.demo.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author zengxp
 * @date 2022/1/16 15:01
 */
@Mapper
public interface ConvertBasic {
    ConvertBasic INSTANCE = Mappers.getMapper(ConvertBasic.class);

    OrderDTO orderPo2OrderDto(OrderPO orderPO);
}
