package designpatterns.observermode.demo02;

import lombok.Data;

import java.util.List;

/**
 * 彩票信息
 *
 * @Author: gaolingfeng
 * @Date: 2021/7/4 21:10
 */
@Data
public class TicketInfo {
    /**
     * 奖金信息
     */
    private List<Prize> prizes;
    /**
     * 消息
     */
    private String message;
}
