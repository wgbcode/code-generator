package com.yupi.maker.cli.command;

import com.yupi.maker.generator.file.MainGenerator;
import com.yupi.maker.model.DataModel;
import freemarker.template.TemplateException;
import lombok.Data;
import picocli.CommandLine;

import java.io.IOException;
import java.util.concurrent.Callable;

@CommandLine.Command(name="generate",description = "生成代码",mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {

    // 获取参数 => 解析参数 => 参数赋值
    // 在执行线程之前，会先要求用户输入参数。用户输入的参数会赋值给 loop、author、outputText
    // 赋值完成后，才会去执行线程
    @CommandLine.Option(names={"--needGit"},arity="0..1",description = "是否生成 .gitignore 文件",interactive = true,echo = true)
    private boolean needGit = true;

    @CommandLine.Option(names={"-l","--loop"},arity="0..1",description = "是否循环",interactive = true,echo = true)
    private boolean loop;

    @CommandLine.Option(names={"-a","--author"},arity="0..1",description = "作者",interactive = true,echo = true)
    private String author = "wgb";

    @CommandLine.Option(names={"-o","--outputText"},arity="0..1",description = "输出文本",interactive = true,echo = true)
    private String outputText = "sum=";

    @Override
    public Integer call() throws TemplateException, IOException {
        DataModel config = new DataModel();
        // 因为属性都是私有的，所以要访问属性时，需要有 Getter 方法，所以要加上 @Data 注解
        config.setLoop(loop);
        config.setAuthor(author);
        config.setOutputText(outputText);
        MainGenerator.doGenerator(config);
        return 0;
    }
}
