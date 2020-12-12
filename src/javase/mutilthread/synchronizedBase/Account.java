package javase.mutilthread.synchronizedBase;

/**
 * @author gaolingfeng
 */
public class Account {
    /**
     * 账号
     */
    private String accountNum;
    /**
     * 余额
     */
    private double balance;

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * 构造方法
     * @param accountNum
     * @param balance
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
