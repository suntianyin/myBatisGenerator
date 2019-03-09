package com.apabi.flow.jdkAop;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleAopTest {
    public static void main(String[] args) {
        MethodInvocation methodInvocation=()->{System.out.println("gohome");};
        HelloService helloService=new HelloServiceImpl();
        Advice advice=new BeforeAdvice(helloService,methodInvocation);
        HelloService helloService1=(HelloService)SimpleAop.invoke(helloService,advice);
        helloService1.work();
        //总结：Advice通知方法继承InvocationHandler      被增强对象生成代理对象o 通过Object o=Proxy.newProxyInstance(a,b,c)
        // a类加载器 b接口 c增强方法对象  methodInvocation 切面

//        List<Integer> nums = Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);
//        System.out.println("sum is:"+nums.stream().filter(num -> num != null).
//                distinct().mapToInt(num -> num * 2).
//                peek(System.out::println).skip(2).limit(4).sum());

//        List<Integer> nums = Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);
//        List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).
//                collect(() -> new ArrayList<Integer>(),
//                        (list, item) -> list.add(item),
//                        (list1, list2) -> list1.addAll(list2));
//        List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).
//                collect(Collectors.toList());
//        List<Integer> ints = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
//        List<Integer> ints = Lists.newArrayList(1,2);
//        System.out.println("ints sum is:" + ints.stream().reduce((sum, item) -> sum + item).get());
//        System.out.println("ints sum is:" + ints.stream().mapToInt(num->num).sum());
//        List<Integer> ints = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
//        System.out.println("ints sum is:" + ints.stream().sorted().mapToInt(num -> num * 2).peek(System.out::println).count());
//        List<String> names = new ArrayList<>();
//        names.add("TaoBao");
//        names.add("ZhiFuBao");
//        List<String> lowercaseNames = names.stream().map( name ->  name.toLowerCase()).collect(Collectors.toList());
//        List<String> lowercaseNames = names.stream().map(String::toLowerCase).collect(Collectors.toList());
//        String[] array = {"a", "b", "c"};
//        for(Integer i : Lists.newArrayList(1,2,3)){
//            Stream.of(array).map(item -> Strings.padEnd(item, i, '@')).forEach(System.out::println);
//        }
//        String[] array = {"a", "b", "c"};
//        for(int i = 1; i<4; i++){
//            int finalI = i;
//            Stream.of(array).map(item -> Strings.padEnd(item, finalI, '@')).forEach(System.out::println);
//        }

    }
}
