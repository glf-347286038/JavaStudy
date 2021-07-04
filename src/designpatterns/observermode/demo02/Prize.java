package designpatterns.observermode.demo02;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 奖金
 *
 * @Author: gaolingfeng
 * @Date: 2021/7/4 21:21
 */
@Data
public class Prize {
    /**
     * 号码
     */
    private String no;
    /**
     * 中奖等级
     */
    private Integer level;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 中奖者姓名
     */
    private String userName;
    /**
     * 中奖者手机号
     */
    private String userPhone;
}
