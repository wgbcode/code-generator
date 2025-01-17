package com.yupi.maker.generator.file;

import cn.hutool.core.io.FileUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class DynamicFileGenerator {

    public static void doGenerator(String inputPath, String outputPath,Object mode) throws IOException, TemplateException {
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模板文件所在的路径
        File parentPathFile = new File(inputPath).getParentFile();
        System.out.println(parentPathFile);
        configuration.setDirectoryForTemplateLoading(parentPathFile);

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        // 指定输出格式
        configuration.setNumberFormat("0.######");

        // 创建模板对象，加载指定模板
        System.out.println(new File(inputPath).getName());
        Template template = configuration.getTemplate(new File(inputPath).getName());

        // 如果文件不存在则创建目录
        if(!FileUtil.exist(outputPath)) {
            FileUtil.touch(outputPath);
        }

        // 指定生成文件的路径和名称
        Writer out = new FileWriter(outputPath);

        // 生成文件
        template.process(mode, out);

        // 关闭
        out.close();
    }
}
