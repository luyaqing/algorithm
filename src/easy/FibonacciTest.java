package easy;

/**
 * @Description
 *         任意给定一个数字K， 在斐波拉契数列中找到最少的数，使得他们的和等于K, 请问是几个数字
 * @Author Hasee
 * @Date 2022/4/12 12:04
 * @Version 1.0
 */
public class FibonacciTest {

    public static int getMinCount4NumK(int k) {

        // 边界条件不要忘记
        if (k < 2) {
            return 1;
        }

        int a = 1;
        int b = 1;

        // 循环条件不要忘记
        while (b < k) {
            b += a;
            a = b - a;
        }

        // 返回条件不要忘记
        if (b == k) {
            return 1;
        }

        // 核心的计算条件
        return 1 + getMinCount4NumK(k - a);
    }
}
