package designpatterns.observermode.demo02;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象目标
 *
 * @Author: gaolingfeng
 * @Date: 2021-07-04 20:47
 */
abstract class AbstractTicketSubject {
    /**
     * 开奖消息
     */
    protected TicketInfo ticketInfo;
    /**
     * 观察者集合
     */
    protected List<AbstractObserver> abstractObservers = new ArrayList<>();

    /**
     * 添加观察者
     */
    public void add(AbstractObserver abstractObserver) {
        abstractObservers.add(abstractObserver);
    }

    /**
     * 通知所有观察者
     *
     * @param ticketInfo 开奖消息
     */
    abstract void notifyObservers(TicketInfo ticketInfo);
}
