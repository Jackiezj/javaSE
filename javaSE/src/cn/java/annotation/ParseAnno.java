package cn.java.annotation;

import java.lang.reflect.Method;

/**
 * 解析(使用)注解
 * 不能改变该类的任何代码。可以创建任意类的对象，可以执行任意方法
 */
@CheckAnno(className = "cn.java.domain.Calculator", methodName = "multiplication")
public class ParseAnno {
    public static void main(String[] args) throws Exception {
        // 获取注解对象
        Class<ParseAnno> cls = ParseAnno.class;  // 获取该类字节码文件对象
        CheckAnno checkAnno = cls.getAnnotation(CheckAnno.class);  //  获取上边的注解对象, 其实就是在内存中生成了一个该注解接口的子类实现对象

        // 获取注解对象的属性
        String className = checkAnno.className();
        String methodName = checkAnno.methodName();

        // 利用反射技术动态加载类方法执行
        Class<?> aClass = Class.forName(className);
        Method method = aClass.getDeclaredMethod(methodName);
        method.setAccessible(true);
        Object o = aClass.newInstance();
        Object invoke = method.invoke(o);
    }
}
