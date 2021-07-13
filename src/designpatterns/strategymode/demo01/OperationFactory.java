package designpatterns.strategymode.demo01;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaolingfeng
 */
public class OperationFactory {
    private final static Map<String, Strategy> OPERATION_MAP = new HashMap<>();

    static {
        OPERATION_MAP.put("add", new OperationAdd());
        OPERATION_MAP.put("multiply", new OperationMultiply());
        OPERATION_MAP.put("subtract", new OperationSubtract());
    }

    /**
     * @param operation 操作
     * @return 具体策略实现类
     */
    public static Strategy getOperation(String operation) {
        return OPERATION_MAP.get(operation);
    }
}
