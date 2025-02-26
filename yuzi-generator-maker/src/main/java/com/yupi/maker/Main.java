package com.yupi.maker;

import cn.hutool.extra.template.TemplateException;
import com.yupi.maker.generator.main.MainGenerator;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws TemplateException, IOException, InterruptedException, freemarker.template.TemplateException {
        MainGenerator mainGenerator = new MainGenerator();
//        args = new String[]{"generate","--needGit=false"};
        mainGenerator.doGenerate();
    }
}
