package javase.mutilthread.synchronizedBase;

import lombok.Data;

/**
 * @author gaolingfeng
 */
@Data
public class Account {
    /**
     * 账号
     */
    private String accountNum;
    /**
     * 余额
     */
    private double balance;

    /**
     * 构造方法
     *
     * @param accountNum 账户
     * @param balance    余额
     */
    Account(String accountNum,double balance){
        this.accountNum = accountNum;
        this.balance = balance;
    }

    /**
     * 对外提供一个取款的方法
     */
    public void withdraw(double money){
        try {
            double after = balance - money;
            Thread.sleep(1000);
            this.setBalance(after);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
