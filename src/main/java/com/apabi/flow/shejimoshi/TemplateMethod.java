package com.apabi.flow.shejimoshi;
//模版方法
public class TemplateMethod extends AbstractCalculator{
    @Override
    public int calculate(int num1, int num2) {
        return num1+num2;
    }

    public static void main(String[] args) {
        String exp = "8+8";
        AbstractCalculator cal = new TemplateMethod();
        int result = cal.calculate(exp, "\\+");
        System.out.println(result);
    }
}
abstract class AbstractCalculator{//计数器
    abstract public int calculate(int num1,int num2);
    public int calculate(String exp,String opt){
        int array[] = split(exp,opt);
        return calculate(array[0],array[1]);
    };
    public int[] split(String exp,String opt){
        String array[] = exp.split(opt);
        int arrayInt[] = new int[2];
        arrayInt[0] = Integer.parseInt(array[0]);
        arrayInt[1] = Integer.parseInt(array[1]);
        return arrayInt;
    }
}