package com.yupi.cli.command;

import com.yupi.generator.MainGenerator;
import com.yupi.model.MainTemplateConfig;
import freemarker.template.TemplateException;
import lombok.Data;
import picocli.CommandLine;

import java.io.IOException;
import java.util.concurrent.Callable;

@CommandLine.Command(name="generate",description = "生成代码",mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {

    @CommandLine.Option(names={"-l","--loop"},arity="0..1",description = "是否循环",interactive = true,echo = true)
    private boolean loop;

    @CommandLine.Option(names={"-a","--author"},arity="0..1",description = "作者",interactive = true,echo = true)
    private String author = "yuzi";

    @CommandLine.Option(names={"-o","--outputText"},arity="0..1",description = "输出文本",interactive = true,echo = true)
    private String outputText = "sum=";

    @Override
    public Integer call() throws TemplateException, IOException {
        MainTemplateConfig config = new MainTemplateConfig();
        config.setLoop(true);
        config.setAuthor("吴廣彬");
        config.setOutputText("总和=");
        MainGenerator.doGenerator(config);
        return 0;
    }
}
