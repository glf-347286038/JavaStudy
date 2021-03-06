package designpatterns.observermode.demo02;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 具体观察者-中二等奖
 * @Author: gaolingfeng
 * @Date: 2021/7/4 20:59
 */
public class ConcreteTicketObserver02 extends AbstractObserver{
    @Override
    void response(TicketInfo ticketInfo) {
        // 一等奖的信息
        List<Prize> prize = ticketInfo.getPrizes().stream().filter(o->Integer.valueOf(2).equals(o.getLevel())).collect(Collectors.toList());
        for(Prize item:prize){
            System.out.println(ticketInfo.getMessage()+"恭喜:"+item.getUserName()+"中二等奖"+"金额为:"+item.getAmount());
        }
    }
}
