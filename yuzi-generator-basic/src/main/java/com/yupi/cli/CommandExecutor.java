package com.yupi.cli;

import com.yupi.cli.command.ConfigCommand;
import com.yupi.cli.command.GenerateCommand;
import com.yupi.cli.command.ListCommand;
import picocli.CommandLine;

@CommandLine.Command(name="yuzi",mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable {
    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ListCommand())
                .addSubcommand(new ConfigCommand());
    }

    @Override
    public void run() {
        System.out.println("主run方法执行了");
    }

    public Integer doExecutor(String[] args) {
        return commandLine.execute(args);
    }
}
