package com.yupi;

import com.yupi.cli.CommandExecutor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        args = new String[] { "generate","-l","-a","-o" };
//        args = new String[] { "config"};
//        args = new String[] { "list"};
//        args = new String[] { };
        CommandExecutor executor = new CommandExecutor();
        executor.doExecutor(args);
    }
}