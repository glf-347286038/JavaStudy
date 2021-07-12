package designpatterns.strategymode.demo01;

/**
 * @Author: gaolingfeng
 * @Date: 2021/7/5 21:53
 */
public class Context {
    private final Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
