package javase.mutilthread;

/**
 * @author gaolingfeng
 * sleep是属于Thread类中的静态方法，Object是属于Object类中的
 * sleep(毫秒)方法阻塞当前线程，腾出CPU时间片，让给其他线程，但是它的监控状态依然保持着，
 * 当指定的时间到了又会自动恢复运行状态。在调用sleep()过程中，线程不会释放对象锁。
 * 当调用wait()方法时，线程会放弃对象锁，进入等待此对象的等待锁定池，只有针对此对象调用notify()
 * 后本线程才进入对象锁定池准备，获取对象锁进入运行状态。
 */
public class SleepAndWaite {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Thread1());
        thread.setName("thread1");
        thread.start();
        //打断thread的休眠
        thread.interrupt();

        //thread.sleep()阻塞的是当前线程，因为sleep是静态方法等同于Thread.sleep()
        //thread.sleep(5000);
        A a = null;
        //不会报空指针异常，相当于A.m1();
        a.m1();

        //阻塞主线程
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"--->"+i);
            Thread.sleep(500);
        }
    }


    private static class Thread1 implements Runnable{
        @Override
        //Thread中的run方法不抛出异常，所以重写run方法之后，在run方法的声明位置上不能使用
        //throws,所以run方法中的异常只能try...catch
        public void run(){
            for(int i =0;i<10;i++){
                try {
                    System.out.println(Thread.currentThread().getName()+"--->"+i);
                    //让当前线程阻塞一秒
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class A{
    public static void m1(){}
}
