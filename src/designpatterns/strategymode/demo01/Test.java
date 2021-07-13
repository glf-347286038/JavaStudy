package designpatterns.strategymode.demo01;

/**
 * @Author: gaolingfeng
 * @Date: 2021/7/5 22:04
 */
public class Test {
    public static void main(String[] args) {
        int num1 = 8, num2 = 4;
        // 1.创建具体策略实现
        Strategy strategy = new OperationAdd();
        // 2.在创建策略上下文的同时,将具体的策略实现对象注入到策略上下文中
        Context context = new Context(strategy);
        // 3.调用上下文对象的方法来完成具体策略的实现
        System.out.println(num1 + "+" + num2 + "=" + context.executeStrategy(num1, num2));

        Context context1 = new Context(OperationFactory.getOperation("multiply"));
        System.out.println(num1 + "*" + num2 + "=" + context1.executeStrategy(num1, num2));

        Context context2 = new Context(OperationFactory.getOperation("subtract"));
        System.out.println(num1 + "-" + num2 + "=" + context2.executeStrategy(num1, num2));
    }
}
