package javase.mutilthread.synchronizedBase;

/**
 * @author gaolingfeng
 * 异步编程模型：t1线程执行t1的，t2线程执行t2的，两个线程之间谁也不等谁。
 * 同步编程模型：t1线程和t2线程执行，当t1线程必须等t2线程执行结束之后，t1线程才能执行。
 * 什么时候要同步？为什么引入线程同步呢？
 *      1.为了数据的安全。尽管应用程序的使用率降低，但是为了保证数据是安全的，必须加入线程同步机制。
 *      线程同步机制使程序变成了(等同)单线程。
 *      2.什么条件下要使用线程同步？
 *          第一：必须是多线程环境。
 *          第二：多线程环境共享同一个数据。
 *          第三：涉及到修改操作。
 * synchronized原理：t1线程和t2线程，t1线程执行到此处遇到synchronized关键字，就会去找this的对象锁，
 * 如果找到this的对象锁，则进入同步语句块中执行程序。当同步语句块中的代码执行结束后，t1归还this的对象锁。
 * 在t1线程执行同步语句块的过程中，如果t2线程也过来执行以下代码，也遇到synchronized关键字，所以也去找this
 * 的对象锁，但是改对象锁被t1线程持有，只能在这等待this对象锁的归还。
 * synchronized添加到静态方法上，线程执行方法时会找类锁，类锁只有一把，与对象共不共享无关。
 */
public class Thread001 {

    public static void main(String[] args){
        //公共账户
        Account account = new Account("123456",1000);

        Thread thread = new Thread(new Processor(account));
        Thread thread2 = new Thread(new Processor(account));

        thread.start();

        thread2.start();
    }



}

/**
 * 创建一个取款线程
 */
class Processor implements Runnable{

    final Account account;
    Processor(Account account){
        this.account = account;
    }

    @Override
    public void run() {
        //将需要同步的代码，放到同步语句块中，()中为线程共享的的对象
        synchronized (account){
            account.withdraw(500);
            System.out.println("取款成功，余额为："+account.getBalance());
        }
    }
}
