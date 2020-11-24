package javase.exception.customException;

/**
 * 自定义“无效名字异常”
 *      1.编译时异常，直接继承Exception
 *      2.运行时异常，直接继承RuntimeException
 * @author gaolingfeng
 * @date 2020-11-16
 */
public class IllegalNameException extends Exception{
//    public class IllegalNameException extends Exception extends RuntimeException{
    /**
     * 定义异常一般提供两个构造方法
     */
    public IllegalNameException(){}

    public IllegalNameException(String msg){
        super(msg);
    }
}
