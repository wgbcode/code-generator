package com.yupi.model;

import lombok.Data;

/**
 * 静态模板配置
 * 注意事项：注解已自动为私有属性添加 Getter 方法和 Setter 方法
 */
@Data
public class MainTemplateConfig {
    private String author = "yupi";
    private String outputText = "输出结果";
    private boolean loop = false;
}
