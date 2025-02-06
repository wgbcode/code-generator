package com.yupi.maker.meta;

import cn.hutool.Hutool;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

public class MetaManager {

    // volatile 的作用：确保多线程开发环境中，每个线程取到的变量值都是最新唯一值
    // 补充知识：Java 属于多线程开发，每个线程都有自己的工作内存，这些工作内存中的变量会在一定的时间后再合并到共享内存中，
    // 所以会存在延迟的情况。使用 volatile 后，每次变量读写都是直接对共享内存进行操作
    private static volatile Meta meta;

    public static Meta getMetaObject() {
        // 如果已经初始化，就不加锁了。加锁会很影响性能
        if (meta == null) {
            // 多线程开发，确保下面的代码在同一时间只能有一个线程能执行
            synchronized (MetaManager.class) {
                // 只允许第一个线程初始化 Meta
                if (meta == null) {
                    meta = initMeta();
                }
            }
        }
        return meta;
    }

    public static Meta initMeta() {
        String json = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(json, Meta.class);
        return newMeta;
    }
}
