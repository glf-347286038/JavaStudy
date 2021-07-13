package javase.innerClass;

/**
 * 内部类  外部类
 * 成员内部类可以无条件访问外部类的属性和方法，但是外部内想要访问内部类属性或方法时，
 * 必须要创建一个内部类对象，然后通过改对象访问内部类的属性或方法
 * <p>
 * 局部内部类存在与方法中,访问权限仅限于方法或作用域内
 * <p>
 * 静态内部类和成员内部类相比多了一个static修饰符，是不依赖于外部类的
 * 静态内部类不能使用外部类的非静态变量和方法。同时可以知道成员内部类里面是不能含有静态属性和方法的
 * <p>
 * 内部类的好处：
 * 1.完善了java多继承机制，由于每一个内部类都可以独立的继承接口或类，所以无论外部类是否继承或实现
 * 某个类或接口，对于内部类没有影响
 * 2.方便写事件驱动程序
 *
 * @Author gaolingfeng
 */
public class InnerClassTest {
    public static void main(String[] args) {
        //创建成员内部类对象
        ExternalClass externalclass = new ExternalClass();
        ExternalClass.MemberInnerClass memberInnerClass = externalclass.new MemberInnerClass();
        // 创建成员内部类对象
        ExternalClass.MemberInnerClass memberInnerClass1 = externalclass.getClassMemberInnerClass();
    }
}

class ExternalClass {
    private final String name = "外部类";

    public void run() {
        System.out.println("外部类奔跑");
    }

    /**
     * 返回成员内部类的方法
     *
     * @return 成员内部类
     */
    public MemberInnerClass getClassMemberInnerClass() {
        return new MemberInnerClass();
    }

    /**
     * 使用内部内的属性和方法
     */
    public void eat() {
        MemberInnerClass memberInnerClass = new MemberInnerClass();
        System.out.println(memberInnerClass.name + memberInnerClass.value);
        memberInnerClass.say();
    }

    class MemberInnerClass {
        private final String value = "DDD";
        private final String name = "内部类";

        public void say() {
            System.out.println(ExternalClass.this.name);
            System.out.println(name);
            run();
        }
    }
}