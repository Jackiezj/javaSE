package cn.java.annotation.testFramework;

import cn.java.annotation.CheckAnno;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Method;

/**
 * 简单的测试框架
 * 当主方法执行后，会自动自行被检测的所有方法(加了Check注解的方法)，判断方法是否有异常，记录到文件中
 * 存在的问题, 方法参数不能是不定长参数
 */
@CheckAnno(className = "cn.java.annotation.testFramework.Calculator", methodName = "")
public class TestCheck {
    public static void main(String[] args) throws Exception {
        // 获取被测试类字节码对象及对象方法
        Class<TestCheck> testCheckClass = TestCheck.class;
        CheckAnno checkAnno = testCheckClass.getAnnotation(CheckAnno.class);
        String className = checkAnno.className();
        Class<?> cls = Class.forName(className);
        Method[] methods = cls.getMethods();
        Object object = cls.newInstance();

        // 遍历执行被@Check标注的方法
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));
        int count = 0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(Check.class)) {
                try {
                    Object invoke = method.invoke(object);
                } catch (Exception e) {
                    count++;
                    bw.write(method.getName() + "方法异常了");
                    bw.newLine();
                    bw.write("异常名称: " + e.getCause().getClass().getName());
                    bw.newLine();
                    bw.write("异常原因: " + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("=========================");
                    bw.newLine();
                }
            }
        }
        bw.write("本次出现" + count + "次异常");
        bw.flush();
        bw.close();
    }
}
