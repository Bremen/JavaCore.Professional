package Task2.AutoCheckWithReflection;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

public class HomeWorkAutoCheker {
    static public boolean checkHomeWork(File homeworkFile){
        Class homeworkClass = null;
        try {
            System.out.println(homeworkFile.toURL().toString());
            homeworkClass = URLClassLoader.newInstance(new URL[]
                    {homeworkFile.toURL()}).loadClass("HomeWorkForAutoCheck");
//            homeworkClass = URLClassLoader.newInstance(new URL[]
//                    {homeworkFile.toURL()}).loadClass(homeworkFile.getName().replaceFirst("\\.class", ""));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Method[] m = homeworkClass.getDeclaredMethods();

        System.out.println(Arrays.toString(m));

        return false;
    }
}
