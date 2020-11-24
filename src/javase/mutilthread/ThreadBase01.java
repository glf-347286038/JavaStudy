package javase.mutilthread;

/**
 * @author gaolingfeng
 * 三个方法：
 *      1.获取当前线程对象
 *      2.给当前线程对象起名
 *      3.获取当前线程的名字
 */
public class ThreadBase01 {
    public static void main(String[] args){
        //thread保存的内存地址指向的线程是“主线程对象”
        Thread thread = Thread.currentThread();
        //获取线程的名字
        System.out.println(thread.getName());

        Thread thread1 = new Processor01();
        thread1.start();

        Thread thread2 = new Thread(new Processor03());
        thread2.start();
    }
}

class Processor01 extends Thread{
    @Override
    public void run(){
        //thread保存的内存地址指向的线程是t1线程对象
        Thread thread = Thread.currentThread();
        //Thread-0
        System.out.println(thread.getName());
    }
}

class Processor03 implements Runnable{

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
    }
}
