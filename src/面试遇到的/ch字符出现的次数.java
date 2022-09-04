package 面试遇到的;

/**
 * 1-n中，ch字符出现的次数
 * 比如： n = 20,  ch = 1， 则 11 算是两个字符的
 * 1-10   中 有 2 个
 * 11-20 中  有 10个，
 *
 * 多列举几个例子，找出其中的规律
 *       9 ：1 -------  1个
 *      99 ：1 -------  20个
 *     999 ：1 -------  300个
 *    9999 ：1 ------- 4000个
 */
public class ch字符出现的次数 {

    public static void main(String[] args) {

    }

    public static int countDigitOne(int n) {
        int ones = 0;

        for (long m = 1; m <= n; m *= 10) {
            ones += (n/m + 8) / 10 * m  + (n /m % 10 == 1? n % m + 1 : 0);
        }
        return ones;
    }

    // 任意ch字符的计算方式 0 - 9之间的
    public static int countDigitCh(int n, char ch) {
        int temp = ch - '0';
        int count = 0;
        for (int m = 1; m < n; m *= 10) {
            count += (n/m + 9-temp) / 10 * m + (n / m % 10 == 1 ? n%m + 1 : 0);
        }
        return count;
    }
}
