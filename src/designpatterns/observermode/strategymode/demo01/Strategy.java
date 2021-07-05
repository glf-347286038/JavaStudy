package designpatterns.observermode.strategymode.demo01;

/**
 * 策略接口
 *
 * @author gaolingfeng
 */
public interface Strategy {
    /**
     * 执行操作
     *
     * @param num1 数字1
     * @param num2 数字2
     * @return 操作结果
     */
    int doOperation(int num1, int num2);
}
