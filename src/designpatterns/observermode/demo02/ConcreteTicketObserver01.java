package designpatterns.observermode.demo02;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 具体观察者-中一等奖
 *
 * @Author: gaolingfeng
 * @Date: 2021/7/4 20:59
 */
public class ConcreteTicketObserver01 extends AbstractObserver {
    @Override
    void response(TicketInfo ticketInfo) {
        // 一等奖的信息
        List<Prize> prize = ticketInfo.getPrizes().stream().filter(o->Integer.valueOf(1).equals(o.getLevel())).collect(Collectors.toList());
        for(Prize item:prize){
            System.out.println(ticketInfo.getMessage()+"恭喜:"+item.getUserName()+"中一等奖"+"金额为:"+item.getAmount());
        }
    }
}
