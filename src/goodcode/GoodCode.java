package goodcode;

/**
 * @author lfgao
 */
public class GoodCode {
    public static void main(String[] args) {
        testTryCatch();
    }


    /**
     * 测试try catch
     * 在Java开发中,经常使用try-catch进行错误捕获,但是try-catch语句对系统性能而言是非常糟糕的。
     * 虽然一次try-catch中,无法察觉到她对性能带来的损失,但是一旦try-catch语句被应用于循环或是遍历体内，
     * 就会给系统性能带来极大的伤害。
     */
    private static void testTryCatch() {
        int count = 1000000000;

        long start = System.currentTimeMillis();
        int a = 0;
        for (int i = 0; i < count; i++) {
            try {
                a++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long useTime = System.currentTimeMillis() - start;
        System.out.println("useTime:" + useTime);


        long start02 = System.currentTimeMillis();
        int a2 = 0;
        try {
            for (int i = 0; i < count; i++) {
                a2++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long useTime2 = System.currentTimeMillis() - start02;
        System.out.println(useTime2);


    }

}
