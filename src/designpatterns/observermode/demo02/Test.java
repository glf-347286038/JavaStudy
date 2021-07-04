package designpatterns.observermode.demo02;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 利用观察者模式设计一个彩票购买开奖的处理程序,
 * 用户可以自行购买彩票,当彩票开奖后,购买本期彩票的用户都收到消息
 *
 * @Author: gaolingfeng
 * @Date: 2021-07-04 20:43
 */
public class Test {
    public static void main(String[] args) {
        TicketInfo ticketInfo = getTicketInfo();
        AbstractTicketSubject abstractTicketSubject = new ConcreteTicketSubject();
        abstractTicketSubject.abstractObservers.add(new ConcreteTicketObserver01());
        abstractTicketSubject.abstractObservers.add(new ConcreteTicketObserver02());
        abstractTicketSubject.abstractObservers.add(new ConcreteTicketObserver03());
        abstractTicketSubject.notifyObservers(ticketInfo);
    }

    /**
     * 获得开奖信息
     *
     * @return 开奖信息
     */
    private static TicketInfo getTicketInfo() {
        TicketInfo ticketInfo = new TicketInfo();
        ticketInfo.setMessage("七月份双色球开奖啦！一等奖号码为:0011,0012,二等奖号码为:0021,0022");
        List<Prize> prizes = new ArrayList<>();
        Prize prize01 = new Prize();
        prize01.setNo("0011");
        prize01.setAmount(BigDecimal.valueOf(7800.9));
        prize01.setUserName("高凌峰");
        prize01.setLevel(1);
        Prize prize02 = new Prize();
        prize02.setNo("0012");
        prize02.setAmount(BigDecimal.valueOf(7800.9));
        prize02.setUserName("高玲云");
        prize02.setLevel(1);

        Prize prize03 = new Prize();
        prize03.setNo("0022");
        prize03.setAmount(BigDecimal.valueOf(5000));
        prize03.setUserName("李鸿章");
        prize03.setLevel(2);

        Prize prize04 = new Prize();
        prize04.setNo("0032");
        prize04.setAmount(BigDecimal.valueOf(0));
        prize04.setUserName("李莲英");
        prize04.setLevel(0);

        prizes.add(prize01);
        prizes.add(prize02);
        prizes.add(prize03);
        prizes.add(prize04);
        ticketInfo.setPrizes(prizes);
        return ticketInfo;
    }
}
