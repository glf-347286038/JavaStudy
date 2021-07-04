package designpatterns.observermode.demo02;

/**
 * 具体目标
 *
 * @Author: gaolingfeng
 * @Date: 2021/7/4 20:58
 */
public class ConcreteTicketSubject extends AbstractTicketSubject{
    @Override
    void notifyObservers(TicketInfo ticketInfo) {
        for(AbstractObserver abstractObserver:abstractObservers){
            abstractObserver.response(ticketInfo);
        }
    }
}
