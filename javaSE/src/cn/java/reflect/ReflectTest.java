package cn.java.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 测试框架类
 * 不改变该类的任何代码,通过改变pro.properties配置文件,调用该类main入口函数可执行任何方法
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception{
        // 根据配置文件参数获取相应对象
        Class cls = Class.forName(className);
        Method method = cls.getDeclaredMethod(methodName);
        method.setAccessible(true);
        Object o = cls.newInstance();

        // 执行Method对象的方法
        try {
            testMethod(o, method);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // 定义String类型的要执行的类全名和方法名
    private static String className = "";
    private static String methodName = "";

    // 加载配置文件 获取配置值
    static {
        InputStream inputStream = ReflectTest.class.getClassLoader().getResourceAsStream("pro.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        className = properties.getProperty("className");
        methodName = properties.getProperty("methodName");
    }

    /**
     * 执行任意类的任意方法
     */
    public static void testMethod (Object obj, Method md) throws InvocationTargetException, IllegalAccessException {
        Object invoke = md.invoke(obj);
    }

}
