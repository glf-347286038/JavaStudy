package designpatterns.observermode.demo01;

/**
 * 观察者模式使用场景
 * 1:对一个对象状态的更新,需要其他对象的同步更新,而且其他对象的数量动态可变
 * 2:对象仅需将自己的更新通知给其他对象而不需要知道其他对象的细节
 *
 * @Author: gaolingfeng
 * @Date: 2021-07-04 17:12
 */
public class Test {
    public static void main(String[] args) {
        // 人民日报开通了微信公众号
        WeChatSubscribe peopleDaily = new PeopleDaily();
        // 很多用户都开始订阅
        peopleDaily.add(new SpecificObserver01());
        peopleDaily.add(new SpecificObserver02());
        peopleDaily.notifyObserver("房价涨了");
    }

}
