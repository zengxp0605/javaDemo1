package com.stan.autoproxying.component;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author：zengxp
 * @date：2022/4/23 下午4:05
 */
@Component
public class RandomIntGenerator {
    private Random random = new Random();

    private DataCache dataCache;

    // 通过构造函数注入
    RandomIntGenerator(DataCache dataCache) {
        this.dataCache = dataCache;
    }

    public int generate(int min, int max) {
        return random.nextInt(max - min) + min;
    }

}
