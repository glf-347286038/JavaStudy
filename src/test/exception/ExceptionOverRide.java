package test.exception;

import java.io.IOException;

/**
 * @author gaolingfeng
 * 子类不可以抛出比父类更宽、更多的异常
 */
public class ExceptionOverRide {

}

class A extends ExceptionOverRide{

}
class B extends A{
    /**
     * 子类永远无法抛出比父类更多的异常
     * @throws Exception
     */
    public void m1() throws IOException {}
}
