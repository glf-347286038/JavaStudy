package javase.lambda;/*
 * @Author 高凌峰
 * @Date 2020-11-01 18:03
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * lambda表达式，也可称为闭包，它是推动Java 8发布的最重要新特性
 * Lambda允许把函数作为一个方法的参数（函数作为参数传递进方法中）
 * 使用lambda表达式使代码变得更简洁紧凑
 * ->可以叫他“转到”或者 “成为”
 * 语法
 * (parameters) -> expression
 * 或
 * (parameters) -> {statements; }
 * lambda表达式的重要特征：
 * 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值
 * 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号
 * 可选的大括号：如果主体包含了一个语句，就不需要使用大括号
 * 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值
 *
 * @author gaolingfeng
 */
public class LambdaBase {
    public static void main(String[] args){
        //1.使用lambda表达式创建一个线程
        Thread thread = new Thread(() -> {
            for(int i=0;i<4;i++){
                System.out.println(2+":"+i);
            }
        });
        thread.start();

        //1.删除集合中的某个元素例如删除姓名为DD的元素
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("FF",1));
        personList.add(new Person("GG",14));
        personList.add(new Person("DD",18));
        personList.add(new Person("CC",11));

        personList.removeIf(element -> "DD".equals(element.getName()));
        System.out.println(personList.size());


        //2.修改集合中符合条件的数据

        //map():用于映射每个元素到对应的结果。以下代码片段使用 map 输出了元素对应的平方数：
        //Collectors(): 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串：
        personList.stream()
                .map(myFunction -> {
                    if("FF".equals(myFunction.getName())){
                        myFunction.setName("lambda修改");
                    }
                    return myFunction;
                }).collect(Collectors.toList());
        //输出
        personList.forEach(System.out::println);

        //3.修改所有列的数据
        personList.stream().
                map(element -> {
                    element.setName("allUpdate");
                    return element;
                }).collect(Collectors.toList());
        personList.forEach(System.out::println);

        List<String> list= Arrays.asList("a", "b", "c", "d");

        List<String> collect =list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);
        //[A, B, C, D]

    }

    public static class Person{
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

}
