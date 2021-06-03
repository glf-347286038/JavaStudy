package javase.dateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Administrator
 */
public class Test {
    /**
     * 时分格式
     */
    private static final String HOUR_MINUTE_FORMAT = "HH:mm";

    public static void main(String[] args) {
        try {
            boolean rs = belongCalendar("09:00", "08:00", "18:00");
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String targetTime = "2021-06-01";
        String targetWeek = getWeek(targetTime);
        System.out.println(targetTime + "对应" + targetWeek);
        if (!checkWeek("1,2,3,5", targetWeek)) {
            System.out.println("选择的时间不在服务时间内");
        } else {
            System.out.println("选择的时间在服务时间内");
        }

        checkMaxDate();


    }

    /**
     * 判断时间是否在时间段内
     *
     * @param targetTime 要校验的时间
     * @param beginTime  开始时间
     * @param endTime    结束时间
     * @return boolean 校验结果
     */
    public static boolean belongCalendar(String targetTime, String beginTime, String endTime) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(HOUR_MINUTE_FORMAT);
        try {
            // 设置要校验的时间
            Date targetTimeFormat = simpleDateFormat.parse(targetTime);
            Calendar date = Calendar.getInstance();
            date.setTime(targetTimeFormat);
            // 设置开始时间
            Date beginTimeFormat = simpleDateFormat.parse(beginTime);
            Calendar begin = Calendar.getInstance();
            begin.setTime(beginTimeFormat);
            // 设置结束时间
            Date endTimeFormat = simpleDateFormat.parse(endTime);
            Calendar end = Calendar.getInstance();
            end.setTime(endTimeFormat);
            // 因为Calendar类的after边缘时间返回的是false
            if (targetTimeFormat.getTime() == beginTimeFormat.getTime() || targetTimeFormat.getTime() == endTimeFormat.getTime()) {
                return true;
            }
            if (!date.after(begin) || !date.before(end)) {
                return false;
            }
        } catch (ParseException e) {
            throw new Exception("字符串转为date类型发生异常");
        }
        return true;
    }

    /**
     * @param weeks  工作服务日周几,例如1,2,3,4,5
     * @param target 输入的周几例如1
     * @return 是否包含true包含, false不包含
     */
    public static boolean checkWeek(String weeks, String target) {
        boolean result = false;
        String[] arrays = weeks.split(",");
        for (String ele : arrays) {
            if (ele.equals(target)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * 根据年月日获得周几
     *
     * @param date 年月日
     * @return 周几
     */
    public static String getWeek(String date) {
        String[] weeks = {"0", "1", "2", "3", "4", "5", "6"};
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(simpleDateFormat.parse(date));
            int weekIndex = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            if (weekIndex < 0) {
                weekIndex = 0;
            }
            return weeks[weekIndex];
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void checkMaxDate() {
        int i = 7;
        // 判断跨度
        // 获得当前时间跨度七天(7天都是工作日)的那个日期
        // 设置一个7,时间往后推一天,如果是工作日就减1,直到=0
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // 先判断当前时间是否在08:00-18:00之间,不在则开始时间取下一天
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String current = df.format(today);
        System.out.println("当前日期时间为" + current);
        String currentTime = current.substring(11, 16);
        // 如果当前时间在这这个时间段,当天可下单可选,否则取下一天
        try {
            // 系统当前日期
            String targetWeek2 = getWeek(simpleDateFormat.format(calendar.getTime()));
            // 当前时间在区间内
            if (belongCalendar(currentTime, "08:00", "18:00") && checkWeek("1,2,3", targetWeek2)) {
                i--;
                calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 1);
            }
        } catch (Exception e) {
        }
        while (i > 0) {
            // 判断这一天是否是服务日
            String targetDate = simpleDateFormat.format(calendar.getTime());
            String targetWeek1 = getWeek(targetDate);
            // 在服务日,则时间跨度变量就-1,日期往后加一天
            if (checkWeek("1,2,3", targetWeek1)) {
                i--;
            }
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 1);

        }
        System.out.println(simpleDateFormat.format(calendar.getTime()));
    }
}
