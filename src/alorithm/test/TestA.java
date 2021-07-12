package alorithm.test;

import java.util.HashSet;
import java.util.Set;

/**
 * 爬楼梯算法：已知一个楼梯有n个台阶，每次可以选择迈上一个或者两个台阶，求走完一共有多少种不同的走法。
 * A:如果有0个台阶,那么有0种走法
 * B:如果有1个台阶,那么有1种走法
 * C:如果有2个台阶,那么有2种走法
 * D:台阶数多于2,第一步有两个选择,1或者2,之后就有execute(n-1)和execute(2),直到出现了基础情形
 *
 * @Author: gaolingfeng
 * @Date: 2021/7/5 23:51
 */
public class TestA {
    public static void main(String[] args) {

        int n = 50;

        long startTime2 = System.currentTimeMillis();
        System.out.println(execute(n));
        long endTime02 = System.currentTimeMillis();
        System.out.println("高" + (endTime02 - startTime2) + "ms");

        long startTime = System.currentTimeMillis();
        System.out.println(solution(n));
        long endTime = System.currentTimeMillis();
        System.out.println("董" + (endTime - startTime) + "ms");

        System.out.println(lengthOfLongestSubstring("abc"));

    }

    public static int solution(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int execute(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return execute(n - 1) + execute(n - 2);
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        //记录最长子串的长度
        int res = 0;
        //记录开始和结尾的下标
        int end = 0, start = 0;
        //使用set容器不重复
        Set<Character> set = new HashSet<>();
        while (start < n && end < n) {
            //如果窗口右侧的字符已经存在
            if (set.contains(s.charAt(end))) {
                //左侧窗口边界向右
                set.remove(s.charAt(start++));
            } else {
                //如果窗口中无重复，窗口右侧向右滑动
                set.add(s.charAt(end++));
                //同时记录当前最大长度
                res = Math.max(res, end - start);
            }
        }
        return res;
    }

}
