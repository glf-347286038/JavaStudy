package test.exception.customException;

/**
 * @author gaolingfeng
 * 模拟注册
 */
public class Test {
    public static void main(String[] args){
        //假如用户提供的用户名如下
        String userName = "jack";
        //注册
        CustomService customService = new CustomService();
        try{
            customService.regist(userName);
        }catch(IllegalNameException e){
            System.out.println(e.getMessage());
        }

    }
}
