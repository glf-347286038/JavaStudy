package designpatterns.strategymode.demo01;

/**
 * @Author: gaolingfeng 加减乘
 * @Date: 2021/7/5 21:22
 */
public class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
