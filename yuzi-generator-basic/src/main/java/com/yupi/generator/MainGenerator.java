package com.yupi.generator;

import com.yupi.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");

        // 第一步：先生成静态文件（整个目录复制）
        String staticInputPath = projectPath + File.separator + "code-generator-demo-projects"+ File.separator+ "acm-template";
        String staticOutputPath = projectPath;
        StaticGenerator.copyFilesByRecursion(staticInputPath,staticOutputPath);

        // 第二步：使用动态生成替换掉部分文件
        String dynamicInputPath = projectPath + File.separator +  "yuzi-generator-basic/src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator +  "acm-template/src/com/yupi/acm/MainTemplate.java";
        MainTemplateConfig config = new MainTemplateConfig();
        config.setAuthor("wuguangbin");
        config.setOutputText("输出结果(测试）");
        config.setLoop(true);
        DynamicGenerator.doGenerator(dynamicInputPath,dynamicOutputPath,config);
    }


    public static void doGenerator(Object config) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");

        // 第一步：先生成静态文件（整个目录复制）
        String staticInputPath = projectPath + File.separator + "code-generator-demo-projects"+ File.separator+ "acm-template";
        String staticOutputPath = projectPath;
        StaticGenerator.copyFilesByRecursion(staticInputPath,staticOutputPath);

        // 第二步：使用动态生成替换掉部分文件
        String dynamicInputPath = projectPath + File.separator +  "yuzi-generator-basic/src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator +  "acm-template/src/com/yupi/acm/MainTemplate.java";
        DynamicGenerator.doGenerator(dynamicInputPath,dynamicOutputPath,config);
    }
}
