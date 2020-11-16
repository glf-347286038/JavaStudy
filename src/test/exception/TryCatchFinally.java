package test.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author gaolingfeng
 * @date 2020-11-16
 */
public class TryCatchFinally {
    public static void main(String[] args){
        int i =m1();
        //10
        System.out.println(i);
    }

    public static int m1(){
        int i = 10;
        try{
            return i;
        }finally{
            i ++;
            //11
            System.out.println("m1的i="+i);
        }

        /**
         * int i = 10;
         * try{
         *     int temp = i;
         *     return temp;
         * }finally{
         *     i++
         *     System.out.println("m1的i="+1)  //11
         * }
         */
    }

    /**
     * finally语句块时一定会执行的，所以通常在程序中为了保证某资源一定会释放，
     * 所以一般在finally语句块中释放资源。
     */
    public static void m2(){
        FileInputStream fis = null;
        try {
             new FileInputStream("c:/a.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            //为了保证资源一定会释放
            //防止空指针异常
            if(fis!=null){
                try {
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

}
