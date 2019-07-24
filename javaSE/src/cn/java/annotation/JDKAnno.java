package cn.java.annotation;

/**
 * 示例JDK预定义注解
 *  * @Override    ：检测被该注解标注的方法是否是继承自父类(接口)的
 * 	* @Deprecated：该注解标注的内容，表示已过时
 * 	* @SuppressWarnings：压制警告
 * 示例javadoc注解
 *
 * @author java
 * @version 1.0
 * @since 1.5
 */
public class JDKAnno {
    public static void main(String[] args) {

    }

    @Override  // 检测重写
    public String toString() {
        return "JDKAnno{}";
    }

    @Deprecated  // 表示已过时
    @SuppressWarnings("all")  // 压制IDE中所有警告提示
    public void methodDemo () {
        int a = 10;
    }
}
