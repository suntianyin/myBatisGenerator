package com.apabi.flow.shejimoshi;

public class Strategy {
    public static void main(String[] args) {
        String exp = "2+8";
        ICalculator cal = new Plus();
        int result = cal.calculate(exp);
        System.out.println(result);
    }
}
interface ICalculator {
    public int calculate(String exp);
}
abstract class AbstractCalculator1 {

    public int[] split(String exp,String opt){
        String array[] = exp.split(opt);
        int arrayInt[] = new int[2];
        arrayInt[0] = Integer.parseInt(array[0]);
        arrayInt[1] = Integer.parseInt(array[1]);
        return arrayInt;
    }
}
class Plus extends AbstractCalculator1 implements ICalculator {

    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp,"\\+");
        return arrayInt[0]+arrayInt[1];
    }
}
class Minus extends AbstractCalculator1 implements ICalculator {

    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp,"-");
        return arrayInt[0]-arrayInt[1];
    }

}
class Multiply extends AbstractCalculator1 implements ICalculator {

    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp,"\\*");
        return arrayInt[0]*arrayInt[1];
    }
}

