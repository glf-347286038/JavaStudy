package javase.mutilthread;

/**
 * @author gaolingfeng
 * 死锁
 */
public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread thread = new Thread(new T1(o1,o2));
        Thread thread2 = new Thread(new T2(o1,o2));

        thread.start();
        thread2.start();
    }

}

class T1 implements Runnable{
    Object object1;
    Object object2;
    T1(Object object1,Object object2){
        this.object1 = object1;
        this.object2 = object2;
    }
    @Override
    public void run() {
        synchronized (object1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object2){
                System.out.println("没有发生死锁");
            }
        }
    }
}

class T2 implements Runnable{
    Object object1;
    Object object2;
    T2(Object object1,Object object2){
        this.object1 = object1;
        this.object2 = object2;
    }
    @Override
    public void run() {
        synchronized (object2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object1){
                System.out.println("没有发生死锁2");
            }
        }
    }
}
