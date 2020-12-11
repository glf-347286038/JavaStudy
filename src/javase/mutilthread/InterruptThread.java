package javase.mutilthread;

/**
 * @author gaolingfeng
 * 更好的终止一个线程
 */
public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        Thread02 thread02 = new Thread02();
        Thread thread = new Thread(thread02);
        thread.start();

        //主线程终止10秒
        Thread.sleep(10000);

        //终止thread线程  主线程10秒期间 thread线程执行两次for循环
        thread02.run = false;
    }
}

class Thread02 implements Runnable{

    boolean run = true;
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            if(run){
                try {
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName()+"-->"+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                return;
            }
        }
    }
}
