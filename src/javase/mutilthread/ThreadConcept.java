package javase.mutilthread;

/**
 * @author gaolingfeng
 * 1.多进程的作用：单进程计算机只能做一件事情，多进程可以做多个事情，可以同时听音乐（一个进程）和打游戏（一个进程）
 *      计算机CPU只能在一个时间点上做一件事，由于计算机在“音乐进程”和“游戏进程”频繁切换，人类感觉不到，以为是同时在进行。
 * 2.什么是线程？多线程有什么作用？
 *      线程是进程中的一个场景，一个进程可以启动多个线程。多线程不是为了提高执行速度，而是提高应用程序的使用率、cpu的使用率，
 *   多个线程共享“堆内存和方法区内存”，栈内存是独立的，一个线程一个栈。可以给人类一种错觉，感觉多个线程在同时并发执行。
 * 3.java程序的运行原理
 *      java命令启动JVM，等于启动了一个应用程序，表示启动了一个进程，该进程会自动启动一个“主线程”，然后主线程会调用某个
 *      类的main方法，所以main方法运行在主线程中，在此之前的所有程序都是单线程的。
 *
*/

public class ThreadConcept {
    public static void main(String[] args){
        //创建线程
        Thread thread = new Processor();

        //启动,这段代码执行时间结束，告诉JVM载分配一个新的栈给thread线程
        //run方法不需要程序员手动调用，系统线程启动之后自动调用run方法
        thread.start();

//        thread.run(); 这是个普通方法调用，这样做程序只有一个线程，run方法结束了下面程序才会执行


        Thread thread02 = new Thread(new Processor02());
        thread02.start();

        for(int i=0;i<20;i++){
            System.out.println("main"+i);
        }
    }


}
/**
 * 实现多线程的第一种方式：
 *      第一步：继承java.lang.Thread
 *      第二步：重写run方法
 */
class Processor extends Thread{
    /**
     * 重写run方法
     */
    @Override
    public void run(){
        for(int i=0;i<50;i++){
            System.out.println("run-->"+i);
        }
    }
}

/**
 * 实现多线程的第二种方式（推荐） 实现了类接口外还可以继承
 *      第一步：写一个类实现java.lang.Runnable接口
 *      第二步：实现run方法
 */
class Processor02 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<50;i++){
            System.out.println("Runnable"+i);
        }
    }
}

