package com.yupi.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * 静态文件生成器
 */
public class StaticGenerator {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        // 输入路径
        String inputPath = projectPath + File.separator + "code-generator-demo-projects"+ File.separator+ "acm-template";
        // 输出路径
        String outputPath = projectPath;
        // copyFilesByHutool(inputPath, outputPath);
        copyFilesByRecursion(inputPath, outputPath);
    }

    /**
     * 拷贝文件（Hutool 实现，会将输入目录完整拷贝到输入目录下）
     * @param inputPath 输入路径
     * @param outputPath 输出路径
     */
    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath,false);
    }

    /**
     * 自定义方法递归拷贝文件
     * 情形一：文件 A -> 目录 B。文件 A 会直接拷贝到目录 B 下
     * 情形二：文件 A -> 文件 B。文件 A 会覆盖文件 B
     * 情形三：目录 A -> 目录 B。文件 A 会直接拷贝到目录 B 下
     * @param inputPath 输入路径
     * @param outputPath 输出路径
     */
    public static void copyFilesByRecursion(String inputPath, String outputPath) {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);
        try{
            copyFileByRecursion(inputFile,outputFile);
        }catch(Exception e){
            System.err.println("文件复制失败");
            e.printStackTrace();
        }
    }

    public static void copyFileByRecursion(File inputFile, File outputFile) throws IOException {
        if(inputFile.isDirectory()) {
            File childOutputFile = new File(outputFile,inputFile.getName());
            if(!childOutputFile.exists()){
                childOutputFile.mkdirs();
            }
            File[] files = inputFile.listFiles();
            if(ArrayUtil.isEmpty(files)) {
                return;
            }
            for(File file : files) {
                copyFileByRecursion(file, childOutputFile);
            }
        }else{
            Path desPath = outputFile.toPath().resolve(inputFile.getName());
            Files.copy(inputFile.toPath(),desPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }


}
