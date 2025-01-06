package com.yupi.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.yupi.model.MainTemplateConfig;
import picocli.CommandLine;

import java.lang.reflect.Field;

@CommandLine.Command(name = "config", description = "查看参数信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable {

    public void run() {
        // 实现 config 命令的逻辑
        System.out.println("查看参数信息");

//        1、原生方法：
//        // 获取要打印属性信息的类
//        Class<?> myClass = MainTemplateConfig.class;
//        // 获取类的所有字段
//        Field[] fields = myClass.getDeclaredFields();

        // 2、hutoool 工具
        // 利用 Java 的反射机制，获取到类的信息
        // 反射原理：在程序动态运行的时候，动态创建一个新的类（复制），然后根据新的类去实时拿到一些信息（在执行的过程中，变量可能会重新赋值）
        // 反射的作用：在运行时读取类的信息；在运行时操作类
        // 反射机制是 Java 中的一种强大功能，可以动态地获取类的信息、创建对象、调用方法、访问和修改字段等
        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);

        // 遍历并打印每个字段的信息
        for (Field field : fields) {
            System.out.println("字段名称：" + field.getName());
            System.out.println("字段类型：" + field.getType());
//            System.out.println("Modifiers: " + java.lang.reflect.Modifier.toString(field.getModifiers()));
            System.out.println("---");
        }
    }
}
