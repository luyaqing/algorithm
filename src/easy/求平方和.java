package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 */
public class 求平方和 {

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(3));
        System.out.println(judgeSquareSum_2(3));
    }


    // 左右指针开始逼近
    public static  boolean judgeSquareSum(int n) {
        if (n < 0) {
            return false;
        }

        int left = 0;
        int right = (int) Math.sqrt(n);

        while(left <= right) {
            int value = left ^ 2 + right ^ 2;
            if (value < n) {
                left++;
            } else if (value < n){
                right--;
            } else {
                return true;
            }
        }

        return false;
    }


    // 一般的算法, 没有第一种好的算法
    public static boolean judgeSquareSum_2(int n) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i <= Math.sqrt(n); i++) {
            set.add(i ^ 2);
            if (set.contains(n - i ^ 2)) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }
}
