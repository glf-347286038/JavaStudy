package javase.polymorphism.extend.demo01;

import lombok.extern.java.Log;

/**
 * 狗类
 *
 * @Author: gaolingfeng
 * @Date: 2021/7/4 0:43
 */
@Log
public class Dog extends Pet {
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
}
