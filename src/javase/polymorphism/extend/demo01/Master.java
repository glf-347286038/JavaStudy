package javase.polymorphism.extend.demo01;

/**
 * 主人类
 *
 * @Author: gaolingfeng
 * @Date: 2021/7/4 0:44
 */
public class Master {
    /**
     * 主人喂宠物
     *
     * @param pet 宠物
     */
    public void feed(Pet pet) {
        pet.eat();
    }
}
