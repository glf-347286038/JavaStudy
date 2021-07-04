package designpatterns.observermode.demo02;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 具体观察者-未中奖
 *
 * @Author: gaolingfeng
 * @Date: 2021/7/4 20:59
 */
public class ConcreteTicketObserver03 extends AbstractObserver{
    @Override
    void response(TicketInfo ticketInfo) {
        // 一等奖的信息
        List<Prize> prize = ticketInfo.getPrizes().stream().filter(o->Integer.valueOf(0).equals(o.getLevel())).collect(Collectors.toList());
        for(Prize item:prize){
            System.out.println(ticketInfo.getMessage()+item.getUserName()+"未能中奖,请再接再厉");
        }
    }
}
