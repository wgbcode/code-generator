package com.yupi.model;

import lombok.Data;

/**
 * 静态模板配置
 */
@Data
public class MainTemplateConfig {
    private String author;
    private String outputText;
    private boolean loop;
}
