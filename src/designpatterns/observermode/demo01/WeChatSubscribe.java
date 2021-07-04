package designpatterns.observermode.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象目标,微信公众号
 *
 * @Author: gaolingfeng
 * @Date: 2021-07-04 16:18
 */
abstract class WeChatSubscribe {
    /**
     * 定义观察者集合,用于增加\删除订阅者(观察者),可被覆写延迟到子类中实现
     */
    protected List<AbstractUser> abstractUsers = new ArrayList<>();

    /**
     * 增加观察者方法,可进行抽象,延迟到子类中实现
     *
     * @param abstractUser 观察者(订阅者)
     */
    public void add(AbstractUser abstractUser) {
        abstractUsers.add(abstractUser);
    }

    /**
     * 删除观察者方法,可进行抽象
     *
     * @param abstractUser 观察者
     */
    public void remove(AbstractUser abstractUser) {
        abstractUsers.remove(abstractUser);
    }

    /**
     * 通知观察者方法 人民日报
     *
     * @param message 消息
     */
    public abstract void notifyObserver(String message);
}
