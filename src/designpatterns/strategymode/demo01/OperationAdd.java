package designpatterns.strategymode.demo01;

/**
 * @Author: gaolingfeng
 * @Date: 2021/7/5 21:22
 */
public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
