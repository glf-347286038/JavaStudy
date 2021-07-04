package designpatterns.observermode.demo01;

/**
 * 具体观察者
 *
 * @Author: gaolingfeng
 * @Date: 2021/7/4 16:35
 */
public class SpecificObserver01 extends AbstractUser {
    @Override
    void response() {
        System.out.println("买房的人收到了订阅号的消息,收到后非常开心");
    }
}
