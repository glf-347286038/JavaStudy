package javase.string;

/**
 * @author gaolingfeng
 * @description String类的常用方法
 */
public class StringBashMethod {
    public static void main(String[] args){
        //1.char charAt(int index)
        String s1 = "我是齐天大圣";
        //齐
        System.out.println(s1.charAt(2));

        //2.boolean endWith(String endStr)
        //true
        System.out.println("Hello.java".endsWith("java"));
        //true
        System.out.println("Hello.java".endsWith(".java"));
        //true
        System.out.println("Hello.java".endsWith("o.java"));
        //false 有空格
        System.out.println("Hello.java".endsWith("o.java "));

        //3.equalsIgnoreCase(String anotherString)
        //true
        System.out.println("abc".equalsIgnoreCase("Abc"));

        //4.byte[] getBytes();
        byte[] bytes = "abc".getBytes();
        for (int i=0;i<bytes.length;i++){
            System.out.println(bytes[i]);
        }

        //5.int indexOf(String str) 判断此字符串第一次在字符串中出现的下标位置
        //1
        System.out.println("abcd".indexOf("bc"));

        //从下标为1开始 java出现的位置下标10
        System.out.println("java145877java".indexOf("java",1));
        System.out.println("4f87451abc4555".lastIndexOf("5"));
        System.out.println("dfsdf23fdsf".lastIndexOf("sf",1));

        //6.replaceAll   4g444444
        System.out.println("ggg444444".replaceAll("gg","4"));

        //7.split
        String myTimes = "2020,11,16";
        String[] ymd = myTimes.split(",");
        for (int i=0;i<ymd.length;i++){
            System.out.println(ymd[i]);
        }

        //8.subString 将下标1到下标5截出来  abcd
        System.out.println("/abcd/edrddddd".substring(1,5));


        //9.char[] toCharArray[]
        char[] c2 = "我是谁".toCharArray();
        for(int  i=0 ; i<c2.length ; i++){
            System.out.println(c2[i]);
        }

        //10.toUpperCase转换成大写
        System.out.println("ac".toUpperCase());

        //11.toLowerCase转换成小写
        System.out.println("acsD".toLowerCase());

        //12.trim 首末去除空格   f d sf
        System.out.println("f d sf  ".trim());


        //13.valueOf
        Object o = null;
        //这里不会报空指针异常，因为并不是直接调用了toString方法，string.valueOf(object)这个方法对空值进行了处理
        System.out.println(o);
        System.out.println(String.valueOf(o));
        //下面会报空指针异常
//        System.out.println(o.toString());

    }

}
