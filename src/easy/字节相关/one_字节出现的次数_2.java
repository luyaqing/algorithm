package easy.字节相关;

/**
 * LeetCode 338 Counting Bits
 *  给定正整数， 并计算  0 ≤ i ≤ num 之间的数字的二进制中1出现的次数。 返回一个数组
 */
public class one_字节出现的次数_2 {

    public static void main(String[] args) {
        int[] arr = countBits(5);
        for (int i : arr) {
            System.out.print(i);
        }

        System.out.println();

        int[] arr2 = countBits_2(5);
        for (int i : arr2) {
            System.out.print(i);
        }
    }


    // 第一种解法: 使用第一个算法中的解法 for循环搞定
    public static int[] countBits(int n) {
        int[] f = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            f[i] = one_字节出现的次数.hammingWeight(i);
        }
        return f;
    }

    // 第二种解法：动态规划
    public static int[] countBits_2(int n) {
        int[] f = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            f[i] = f[i >> 1] + (i & 1);
        }
        return f;
    }
}
