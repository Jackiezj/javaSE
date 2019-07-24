package cn.java.domain;

/**
 * 计算器类
 */
public class Calculator {

    private int privateVar;
    public int publicVar;

    @Override
    public String toString() {
        return "Calculator{" +
                "privateVar=" + privateVar +
                ", publicVar=" + publicVar +
                '}';
    }

    public int getPrivateVar() {
        return privateVar;
    }

    public void setPrivateVar(int privateVar) {
        this.privateVar = privateVar;
    }

    public int getPublicVar() {
        return publicVar;
    }

    public void setPublicVar(int publicVar) {
        this.publicVar = publicVar;
    }

    public Calculator(int priVar, int pubVar) {
        this.privateVar = priVar;
        this.publicVar = pubVar;
    }

    public Calculator() {
    }

    /**
     * 加法
     * @param a
     * @param b
     * @return
     */
    public int add (int a , int b){
        //int i = 3/0;

        return a - b;
    }

    private void multiplication () {
        System.out.println("multiplication....");
    }

    /**
     * 减法
     * @param a
     * @param b
     * @return
     */
    public int sub (int a , int b){
        return a - b;
    }

}
