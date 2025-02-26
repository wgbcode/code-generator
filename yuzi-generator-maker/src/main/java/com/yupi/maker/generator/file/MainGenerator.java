package com.yupi.maker.generator.file;

import com.yupi.maker.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
//    public static void main(String[] args) throws TemplateException, IOException {
//        String projectPath = System.getProperty("user.dir");
//
//        // 第一步：先生成静态文件（整个目录复制）
//        String staticInputPath = projectPath + File.separator + "code-generator-demo-projects"+ File.separator+ "acm-template";
//        String staticOutputPath = projectPath;
//        StaticFileGenerator.copyFilesByHutool(staticInputPath, staticOutputPath);
//
//        // 第二步：使用动态生成替换掉部分文件
//        String dynamicInputPath = projectPath + File.separator +  "yuizi-generator-maker/src/main/resources/templates/MainTemplate.java.ftl";
//        String dynamicOutputPath = projectPath + File.separator +  "acm-template/src/com/yupi/acm/MainTemplate.java";
//        DataModel config = new DataModel();
//        config.setAuthor("wuguangbin");
//        config.setOutputText("输出结果(测试）");
//        config.setLoop(true);
//        DynamicFileGenerator.doGenerator(dynamicInputPath,dynamicOutputPath,config);
//    }


    public static void doGenerator(Object config) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");

        // 第一步：先生成静态文件（整个目录复制；别人写的项目）
        String staticInputPath = projectPath + File.separator + "code-generator-demo-projects"+ File.separator+ "acm-template";
        String staticOutputPath = projectPath;
        StaticFileGenerator.copyFilesByHutool(staticInputPath,staticOutputPath);

        // 第二步：使用动态生成替换掉部分文件(自己定义的 ftl）
        String dynamicInputPath = projectPath + File.separator +  "yuizi-generator-maker/src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator +  "acm-template/src/com/yupi/acm/MainTemplate.java";
        DynamicFileGenerator.doGenerate(dynamicInputPath,dynamicOutputPath,config);
    }
}
