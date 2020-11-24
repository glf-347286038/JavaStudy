package javase.exception.customException;

/**
 * @author gaolingfeng
 * 顾客相关的业务
 */
public class CustomService {
    /**
     * 对外提供一个注册方法
     */
    public void regist(String name) throws IllegalNameException{
        if(name.length() < 6){
            throw new IllegalNameException("用户长度异常");
        }
        //完成注册
        System.out.println("注册成功");
    }
}
