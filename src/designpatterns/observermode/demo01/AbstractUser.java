package designpatterns.observermode.demo01;

/**
 * 抽象观察者
 *
 * @Author: gaolingfeng
 * @Date: 2021-07-04 16:19
 */
abstract class AbstractUser {
    /**
     * 接收消息后的响应方法
     */
    abstract void response();
}
