package javase.polymorphism.extend.demo01;

/**
 * 猫类
 *
 * @author: gaolingfeng
 * @date: 2021/7/4 0:18
 */
public class Cat extends Pet {
    /**
     * 猫吃东西
     */
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}
