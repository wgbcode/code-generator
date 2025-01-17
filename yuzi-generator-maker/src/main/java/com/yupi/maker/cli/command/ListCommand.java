package com.yupi.maker.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;

import java.io.File;
import java.util.List;

@CommandLine.Command(name = "list", description = "查看文件列表", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable {

    public void run() {

        // 拿到根级目录
        String projectPath = System.getProperty("user.dir");

        // 整个项目的根路径
        File parentFile = new File(projectPath).getParentFile();

        // 输入路径
        String inputPath = new File(parentFile, "/code-generator/code-generator-demo-projects/acm-template").getAbsolutePath();

        // 根据路径遍历所有目录，并返回一个数组
        List<File> files = FileUtil.loopFiles(inputPath);

        for (File file : files) {
            System.out.println(file);
        }
    }

}
