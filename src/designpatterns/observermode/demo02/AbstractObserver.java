package designpatterns.observermode.demo02;

/**
 * 抽象观察者
 *
 * @Author: gaolingfeng
 * @Date: 2021/7/4 20:49
 */
abstract class AbstractObserver {
    /**
     * 观察者响应
     *
     * @param ticketInfo 开奖信息
     */
    abstract void response(TicketInfo ticketInfo);
}
