package designpatterns.observermode.demo01;

/**
 * 人民日报 具体目标  具体观察者
 *
 * @Author: gaolingfeng
 * @Date: 2021-07-04 16:27
 */
public class PeopleDaily extends WeChatSubscribe {
    /**
     * 发送消息
     *
     * @param message 消息
     */
    @Override
    public void notifyObserver(String message) {
        System.out.println(message);
        for (AbstractUser abstractUser : abstractUsers) {
            abstractUser.response();
        }
    }
}
