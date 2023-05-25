package com.stan.msrv.framework.utils;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author：zengxp
 */
public final class ThreadContextUtil {
    private static ThreadLocal<Map<String, Object>> context = new ThreadLocal();

    private static class InstanceHolder {
        public static ThreadContextUtil INSTANCE = new ThreadContextUtil();
    }

    private ThreadContextUtil() {
    }

    public static ThreadContextUtil getInstance() {
        return InstanceHolder.INSTANCE;
    }

    // 实例方法
    public void set(final String key, final Object value) {
        Map<String, Object> map = context.get();
        if (null == map) {
            map = Maps.newHashMap();
        }
        map.put(key, value);
        context.set(map);
    }

    public Object get(final String key) {
        Map<String, Object> map = context.get();
        if (null == map) {
            return null;
        }
        return map.get(key);
    }

    public void remove(final String key) {
        Map<String, Object> map = context.get();
        if (null != map) {
            map.remove(key);
            context.set(map);
        }
    }

    public void clean() {
        Map<String, Object> map = context.get();
        if (null != map) {
            map.clear();
            context.set(map);
        }
    }

}
