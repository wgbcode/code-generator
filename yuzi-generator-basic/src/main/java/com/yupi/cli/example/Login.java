package com.yupi.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

public class Login implements Callable<Integer> {
    @Option(names = {"-u", "--user"}, description = "User name")
    String user;

    @Option(names = {"-p", "--password"}, description = "Passphrase", interactive = true,required = true,prompt = "请输入密码：", arity="0..1")
    String password;

    @Option(names = {"-cp", "--checkPassword"}, description = "再次输入密码", interactive = true,required = true,prompt = "请再次输入密码：", arity="0..1")
    String checkPassword;

    public Integer call() throws Exception {
        System.out.println("password = " + password);
        System.out.println("checkPassword = " + checkPassword);
        return 0;
    }

    public static void main(String[] args) {
        // -u user123：用户名是 user123
        // -p 开始输入密码。interactive = true，输入密码是交互式的（核心）
        new CommandLine(new Login()).execute("-u", "user123", "-p","-cp");

        // 预设参数：给 -p 设置默认值，但 arity 要设置成 0..1，表示 -p 可输入 0 个或者 1 个参数
//        new CommandLine(new Login()).execute("-u", "user123", "-p","xxx","-cp");
    }
}
