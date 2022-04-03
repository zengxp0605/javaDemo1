package com.stan.mp.generator.service.impl;

import com.stan.mp.generator.entity.Person;
import com.stan.mp.generator.mapper.PersonMapper;
import com.stan.mp.generator.service.IPersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 家庭成员表 服务实现类
 * </p>
 *
 * @author Jason
 * @since 2021-11-11
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

}
