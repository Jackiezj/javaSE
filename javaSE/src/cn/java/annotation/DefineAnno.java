package cn.java.annotation;

import cn.java.domain.Person;

import java.lang.annotation.*;
import java.lang.reflect.Type;

/**
 * 自定义注解类: 注解本质上就是一个接口，该接口默认继承Annotation接口
 * 元注解: 用于描述注解的注解
 *  * @Target()  作用范围: 类,方法,属性
 *  * @Retention(RetentionPolicy.RUNTIME)  描述注解被保留的阶段 当前被描述的注解，会保留到class字节码文件中，并被JVM读取到
 *  * @Documented  描述注解是否被抽取到api文档中
 *  * @Inherited  描述注解是否被子类继承
 * 属性：接口中的抽象方法
 *  属性的返回值: 类型有下列取值: 基本类型, String, 枚举, 注解, 以上类型的数组
 *  属性的返回值: default给属性默认初始化值
 *  属性赋值: 如果只有一个属性需要赋值，并且属性的名称是value，则value可以省略，直接定义值即可
 *  属性赋值: 数组赋值时，值使用{}包裹。如果数组中只有一个值，则{}可以省略
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DefineAnno {  // 自定义注解
    int age();  // 属性
    String value() default "";
    Person person();
    AnnoDemo anno();

    Person[] persons();
}
