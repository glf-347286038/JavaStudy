package javase.mutilthread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author gaolingfeng
 * 定时器：每隔一段时间执行job
 */
public class TimerJob {
    public static void main(String[] args){
        //1.创建定时器
        Timer timer = new Timer();

        //2.指定定时任务
        Date date = null;
        try {
            date = new Date(String.valueOf(new SimpleDateFormat("yyyy-MM-ss HH:mm:ss").parse("2020-12-12 22:32:00")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timer.schedule(new LogTimerTask(),date,5000);
    }
}

//指定任务
class LogTimerTask extends TimerTask{

    @Override
    public void run() {
        System.out.println("sss");
    }
}
