package Task1.AnnotationsForTests;

import Task1.AnnotationsForTests.annotations.AfterSuite;
import Task1.AnnotationsForTests.annotations.BeforeSuite;
import Task1.AnnotationsForTests.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestLauncher {
    static void start(String className) throws RuntimeException{
        try {
            launchTests(Class.forName(className));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void start(Class classObject) throws RuntimeException{
        launchTests(classObject);
    }

    static private void launchTests(Class classObject) throws RuntimeException{
        Method[] m = classObject.getDeclaredMethods();
        Map<String, ArrayList<Integer>> order = new HashMap<>();
        boolean oneBeforeSuitBlock = false;
        boolean oneAfterSuitBlock = false;
        for (int i = 0; i < m.length; i++) {
            if(m[i].isAnnotationPresent(BeforeSuite.class)){
                if(oneBeforeSuitBlock){
                    throw new RuntimeException(String.format("EXCEPTION: В классе %s более одного блока с аннотацией @BeforeSuit", classObject.getName()));
                }
                else{
                    oneBeforeSuitBlock = true;
                    order.put("before", new ArrayList<>(Arrays.asList(i)));
                }
            }
            if(m[i].isAnnotationPresent(AfterSuite.class)){
                if(oneAfterSuitBlock){
                    throw new RuntimeException(String.format("EXCEPTION: В классе %s более одного блока с аннотацией @AfterSuit", classObject.getName()));
                }
                else{
                    oneAfterSuitBlock = true;
                    order.put("after", new ArrayList<>(Arrays.asList(i)));
                }
            }
            if(m[i].isAnnotationPresent(Test.class)) {
                int priorityValue = m[i].getAnnotation(Test.class).priority();
                String key = "priority" + priorityValue;
                if(order.containsKey(key)){
                    order.get(key).add(i);
                }
                else{
                    order.put(key, new ArrayList<>(Arrays.asList(i)));
                }
            }
        }

        try {
            if(order.containsKey("before")){
                int index = order.get("before").get(0);
                m[index].invoke(classObject);
            }

            for (int i = 10; i > 0; i--) {
                String key = "priority" + i;
                if(order.containsKey(key)){
                    for (Integer index : order.get(key)) {
                        m[index].invoke(classObject);
                    }
                }
            }

            if(order.containsKey("after")){
                int index = order.get("after").get(0);
                m[index].invoke(classObject);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
