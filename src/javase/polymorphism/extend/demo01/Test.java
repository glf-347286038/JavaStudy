package javase.polymorphism.extend.demo01;

/**
 * 入口类
 *
 * @Author: gaolingfeng
 * @Date: 2021/7/4 0:46
 */
public class Test {
    public static void main(String[] args) {
        Pet pet = new Cat();
        Pet pet2 = new Dog();
        Master master = new Master();
        // 父类型引用指向子类对象,编译的时候编译器发现pet是Pet类,会去Pet类中找eat()方法,
        // 结果找到了,编译通过,运行的时候,底层实际的对象是什么,就自动调用到该实际对象的eat()方法。
        master.feed(pet);
        master.feed(pet2);
    }
}
