package com.yupi.model;

import lombok.Data;

/**
 * 静态模板配置
 */
@Data
public class MainTemplateConfig {
    private String author = "yupi";
    private String outputText = "输出结果";
    private boolean loop = false;
}
