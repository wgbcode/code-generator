package com.yupi.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

// 创建命令
// mixinStandardHelpOptions 开启用户帮助手册功能
@Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true)
public class ASCIIArt implements Runnable {

    // 解析并设置参数1（如 -s 10。10是给 s 的参数）
    @Option(names = { "-s", "--font-size" }, description = "Font size")
    int fontSize = 19;

    // 解析并设置参数2（如 xxx、yyy、zzz。它们是给整个程序的参数）
    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli",
            description = "Words to be translated into ASCII art.")
    private String[] words = { "Hello,", "picocli" };

    // 实现接口 Runnable 中的方法
    @Override
    public void run() {
        // 自己实现业务逻辑
        System.out.println("fontSize = " + fontSize);
        System.out.println("words = " + String.join(",", words));
    }

    // 命令行初始化：生成一个命令行实例
    // 参数 args 中的值会被解析出来，并赋值到变量中
    public static void main(String[] args) {
        int exitCode = new CommandLine(new ASCIIArt()).execute(args);
        System.exit(exitCode);
    }
}
