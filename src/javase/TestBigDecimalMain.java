package javase;

import java.math.BigDecimal;
/** @Author 高凌峰
 * @Date 2020-11-01 17:10
 */
public class TestBigDecimalMain {
    public static void main(String[] args){

        TestBigDecimalMain testBigDecimalMain = new TestBigDecimalMain();
        //1.测试去除末尾的0
        testBigDecimalMain.removeZero();

        //2.加减乘除操作
        testBigDecimalMain.add();
        testBigDecimalMain.subtract();
        //multiply  乘法
        //divide    除法

        System.out.println("-----------------");

        System.out.println((BigDecimal.valueOf(3).divide(BigDecimal.valueOf(8),9,BigDecimal.ROUND_DOWN)).stripTrailingZeros());

    }

    /**
     *1.测试去除末尾的0
     */
    public void removeZero(){
        Person person = new Person();
        person.setName("高");
        person.setOverRate(BigDecimal.valueOf(0.0100));
        System.out.println("-----去除0之前------");
        System.out.println(person.toString());
        System.out.println("-------去除0之后------");
        person.setOverRate(person.getOverRate().stripTrailingZeros());
        System.out.println(person.toString());
    }

    public void add(){
        BigDecimal bigDecimal01 = new BigDecimal("0.004");
        BigDecimal bigDecimal02 = BigDecimal.valueOf(0.007);
        System.out.println("-------加法-------");
//        System.out.println(bigDecimal01+bigDecimal02); 错误
        System.out.println(bigDecimal01 +"加上"+bigDecimal02 +"结果为"+ bigDecimal01.add(bigDecimal02));
    }

    public void subtract(){
        BigDecimal bigDecimal01 = new BigDecimal("0.004");
        BigDecimal bigDecimal02 = BigDecimal.valueOf(0.007);
        System.out.println("-------减法-------");
//        System.out.println(bigDecimal01+bigDecimal02); 错误
        System.out.println(bigDecimal01 +"减去"+bigDecimal02 +"结果为"+ bigDecimal01.subtract(bigDecimal02));
    }



    /**
     * 创建一个内部类
     */
    public class Person{
        private String name;
        private BigDecimal overRate;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getOverRate() {
            return overRate;
        }

        public void setOverRate(BigDecimal overRate) {
            this.overRate = overRate;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", overRate=" + overRate +
                    '}';
        }
    }
}
