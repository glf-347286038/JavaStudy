package javase.mutilthread;

/**
 * @author gaolingfeng
 * 守护线程是这样的，所有的用户线程结束生命周期，守护线程才会结束生命周期，只要有一个用户线程存在，
 * 那么守护线程就不会结束，例如JAVA中的垃圾回收器就是一个守护线程，只有应用程序中所有的线程结束，它才结束。
 * 可以使用守护线程优雅的停止用户线程，就是将标记放到while中去判断
 */
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new T3());
        thread.setName("t1");
        //将线程标记为守护线程，当用户线程结束后则守护线程结束，否则t1线程永远执行
        thread.setDaemon(true);
        thread.start();
        for (int i =0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"-->"+i);
            Thread.sleep(500);
        }
    }
}

class T3 implements Runnable{
    @Override
    public void run() {
        int i = 0;
        while (true){
            i ++;
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
    }
}
