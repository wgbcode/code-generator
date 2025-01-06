package com.yupi.cli;

import com.yupi.cli.command.ConfigCommand;
import com.yupi.cli.command.GenerateCommand;
import com.yupi.cli.command.ListCommand;
import picocli.CommandLine;

@CommandLine.Command(name="yuzi",mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable {
    private final CommandLine commandLine;

//    在实例初始化时赋值，并创建四个线程（一个主命令线程；三个子命令线程）
    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ListCommand())
                .addSubcommand(new ConfigCommand());
    }

    @Override
    public void run() {
        System.out.println("请输入子命令");
    }

    public Integer doExecutor(String[] args) {
//      根据 args 参数去匹配，去执行主命令线程或者对应的子命令线程
        return commandLine.execute(args);
    }
}
