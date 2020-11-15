package test.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *                           Throwable
 *         Error                                    Exception
 *                                        编译时异常             运行时异常(RuntimeException)
 *
 * Error:java程序运行过程中如果出现了错误，错误是不能处理的，只能退出JVM，例如StackOverflowError
 * Throwable:所有的异常都是可抛出的
 * Exception:Exception是可处理的，如果没有处理异常类，则程序直接退出JVM
 * RuntimeException:发生几率比较高（根据构造方法是否throws）运行时异常，比如NullPointException、OutBindException
 * 编译时异常：所有的编译时异常，要求程序员在编写程序阶段，必须对它进行处理，如果不处理编译都
 * 无法通过，IoException,处理异常有两种方式，捕获和声明抛出，捕获就是try catch,声明抛出就是在方法声明
 * 的位置上使用throws关键字抛出异常。
 */
public class ExceptionBase {
    public static void main(String[] args) throws FileNotFoundException {
        m1();
        //使用throws处理异常不是真正的处理异常而是推卸责任。
        //谁调用就会抛给谁
        //上面的m1方法如果出现了异常，因为采用的是上抛，给了JVM,JVM遇到这个异常就
        //会退出JVM，下面的代码就不会执行了
        System.out.println("Hello word!");
    }
    public static void m1() throws FileNotFoundException {
        m2();
    }
    public static void m2() throws FileNotFoundException {
        m3();
    }
    public static void m3() throws FileNotFoundException {
        new FileInputStream("D:/c.txt");
        //FileInputStream构造方法声明位置上使用throws(向上抛);
        //谁调m3这个方法就需要处理这个异常
    }
    /**
     * 在程序运行过程中发生了FileNotFoundException类型的异常
     * JVM为我们创建了一个FileNotException类型的对象
     * 该对象中携带了以下的信息打印到控制台
     * 并且JVM停掉了程序的运行
     * Exception in thread "main" java.io.FileNotFoundException: D:\c.txt (系统找不到指定的文件。)
     * 	at java.io.FileInputStream.open0(Native Method)
     * 	at java.io.FileInputStream.open(FileInputStream.java:195)
     * 	at java.io.FileInputStream.<init>(FileInputStream.java:138)
     * 	at java.io.FileInputStream.<init>(FileInputStream.java:93)
     * 	at test.exception.ExceptionBase.m3(ExceptionBase.java:35)
     * 	at test.exception.ExceptionBase.m2(ExceptionBase.java:32)
     * 	at test.exception.ExceptionBase.m1(ExceptionBase.java:29)
     * 	at test.exception.ExceptionBase.main(ExceptionBase.java:21)
     */


    /**
     * catch可以写多个，但是必须从上到下，从小到大捕捉
     * 下面这段代码就是可以编译通过的，因为FileNotFoundException属于IOException
     */
    {
        try {
            FileInputStream fis = new FileInputStream("D:/B.txt");
            //上面异常下面不会执行了
            System.out.println("try语句块出现异常，try语句将不再执行，直接执行catch语句块");
            fis.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


}
