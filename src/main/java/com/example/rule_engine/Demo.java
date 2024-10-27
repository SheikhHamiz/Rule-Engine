package com.example.rule_engine;

import com.sun.tools.jconsole.JConsoleContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
import org.apache.commons.jexl2.Script;

public class Demo {
    public static void main(String[] args) {
        JexlEngine jexlEngine = new JexlEngine();
        String expression1 = "age < 30";
        String expression2 = "salary > 10000";
        Script script =jexlEngine.createScript(expression1 +"&&"+ expression2);
        var context = new MapContext();
        context.set("salary", 10000);
        context.set("age",30);
        System.out.println(script.execute(context));
    }
}
