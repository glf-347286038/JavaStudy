package javase.objectClass;/*
 * @Author 高凌峰
 * @Date 2020-11-01 20:21
 */

/**
 * 对于 == 如果作用于基本数据类型的变量，则直接比较其存储的“值”是否相等
 * 如果作用于引用类型的变量，则比较的是其所指向的对象的地址
 * 对于 equals equals方法不能作用于基本数据类型的变量，equals继承Object类，比较的是是否是同一个对象
 * 如果没有对equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址(默认比较的也是内存地址)
 * 如String、Data、Integer等类对equals方法进行了重写的话，比较的是所指向的对象的内容
 *
 *
 * String s1 = new String("hello");在堆内存中创建了一个对象，在方法区中的字符串常量池中创建
 * 了一个"hello"常量值，地址0x001指向new String();
 * new String()本身就是new出来的，所以也有一个地址值0x0001,赋值给String s1,指向了String s1
 * String s2 = "hello";直接赋值，在常量池里找，有就直接赋值，把"hello"的地址0x001给了String s2
 * String s2指向了常量池里的"hello"
 *
 * @author gaolingfeng
 */
public class Equals {
    public static void main(String[] args){
        String x = "x";
        String y = "x";
        String z = new String("string");

        //true
        System.out.print("x==y结果为：");
        System.out.println(x==y);

        //false
        System.out.print("x==z结果为：");
        System.out.println("x==z结果为："+x==z);
        //true
        System.out.println(x.equals(z));


        //没有重写equals方法的两个引用
        Equals equals = new Equals();
        equals.compare();

    }

    public  void compare(){
        Person person01 = new Person();
        person01.setName("高");
        Person person02 = new Person();
        person02.setName("高");
        //结果为false  如果重写了equals方法则结果为true
        System.out.print("没有重写equals方法比较两个类");
       System.out.println(person01.equals(person02));
        //无论有没有重写 下面结果都是false
        System.out.println(person01 == person02);
    }


    public static class Person{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
