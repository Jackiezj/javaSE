package cn.java.reflect;

import cn.java.domain.Calculator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo {
    public static void main(String[] args) throws Exception{
        /*
        Class对象的获取
        同一个字节码文件(*.class)在一次程序运行过程中，只会被加载一次，不论通过哪一种方式获取的Class对象都是同一个。
         */
        Class cls = Class.forName("cn.java.domain.Calculator");  // 多用于配置文件
        Class cls2 = Calculator.class;  // 多用于参数传递
        Calculator calculator = new Calculator();
        Class cls3 = calculator.getClass(); // 多用于对象获取字节码的方式

        /*
        Class对象的功能1: 获取成员变量对象
         */
        // 获取public修饰的某个成员变量
        Field publicVar = cls.getField("publicVar");
        // 获取public修饰的全部成员变量
        Field[] fields = cls.getFields();
        // 获取成员变量, 不考虑修饰符
        Field privateVar = cls.getDeclaredField("privateVar");
        // 获取全部成员变量, 不考虑修饰符
        Field[] declaredFields = cls.getDeclaredFields();

        /*
        Class对象的功能2: 获取构造方法
        getDeclaredConstructor, getConstructors规则与Field相同不再演示
         */
        Constructor constructor = cls.getConstructor();  // 获取空参构造
        Constructor constructor1 = cls.getConstructor(int.class, int.class); // 获取有参构造, int不能使用包装类Integer替换
        Constructor[] constructors = cls.getConstructors();

        /*
        Class对象的功能3: 获取成员方法
         */
        Method methodAdd = cls.getMethod("add", int.class, int.class);
        Method methodMul = cls.getDeclaredMethod("multiplication");

        /*
        Class对象功能4: 获取全类名
         */
        String clsName = cls.getName();

        /*
        Field对象的功能1: 运行时,设置Field所在类的类对象的属性值
        Field对象的功能2: 运行时,获取Field所在类的类对象的属性值
        对于private的Field对象使用暴力反射访问
         */
        publicVar.set(calculator, 1);  // 设置Calculator类对象的属性值
        int publicValue = (int) publicVar.get(calculator);  // 获取Calculator类对象的属性值
        privateVar.setAccessible(true);  // 对于private属性设置强制反射
        privateVar.set(calculator, 2);
        int privateValue = (int) privateVar.get(calculator);

        /*
        Constructor对象的功能: 构造一个类对象
        简写形式: cls.newInstance() 局限:不能指定构造
         */
        Calculator c = (Calculator) constructor.newInstance();  // 获得空参构造出的对象
        Calculator c1 = (Calculator) constructor1.newInstance(1, 2);  // 获得有参构造出的对象
        Calculator c2 = (Calculator) cls.newInstance();  // 直接用类对象获得无参构造出的对象

        /*
        Method对象的功能1: 执行方法,返回方法的返回值
        Method对象的功能2: 获取方法名
         */
        Object invoke = methodAdd.invoke(calculator, 1, 2);  // 执行方法
        String methodName = methodAdd.getName();  // 获取方法名

    }
}
