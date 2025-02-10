package com.yupi.maker.generator;

import java.io.*;

public class JarGenerator {
    public static void main(String[] args) throws IOException, InterruptedException {
        doGenerate("D:\\myProject\\code-generator\\yuzi-generator-maker\\generated");
    }

    public static void doGenerate(String projectDir) throws IOException, InterruptedException {
        // 调用 Process 类执行 Maven 打包命令(需要在本地安装 maven，类似于安装 npm）
        String winMavenCommand = "mvn.cmd clean package -DskipTests=true";
        String otherMavenCommand = "mvn clean package -DskipTests=true";
        String mavenCommand = winMavenCommand;

        // 拿到 Process 实例（通过该实例，可打开命令行工具，执行命令行，获取命令行信息等）
        ProcessBuilder processBuilder = new ProcessBuilder(mavenCommand.split(" "));

        // 指定目录
        processBuilder.directory(new File(projectDir));

        // 相当于打开命令行工具，并开始执行命令
        Process process = processBuilder.start();

        // 读取命令输出
        InputStream inputStream = process.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        // 拿到退出码。0 表示成功，1 表示失败
        // 打包必须有 pom 文件，类似于 package.json
        int exitCode = process.waitFor();
        System.out.println("命令执行结束，退出码" + exitCode);
    }
}
