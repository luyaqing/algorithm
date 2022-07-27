package easy;

import 漫画算法.BitMap的巧用;

/**
 * some demo ： 整数判断是否回文数
 */
public class epoch_test {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1232));
    }

    public static boolean isPalindrome(int number) {

        if (number < 0 || (number % 10) == 0) {
            return false;
        }

        int result = 0;
        while (number > result) {
            result = result * 10 + number % 10;
            number = number / 10;
        }

        return number == result || number == result / 10;
    }
}
