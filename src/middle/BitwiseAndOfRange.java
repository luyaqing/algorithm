package middle;

/**
 * @Description 在一个数组内，循环 & 计算得出结果
 * @Author Hasee
 * @Date 2022/4/11 10:24
 * @Version 1.0
 *
 * ex：
 * 举例：
 * Input: [5,7]
 * Output: 4
 *
 * Input: [0,1]
 * Output: 0
 */
public class BitwiseAndOfRange {

    public static int getBitwiseAndOfRange(int m, int n) {
        int count = 0;
        while (m < n) {
            m >>= 1;
            n >>= 1;

            count ++;
        }

        return m << count;
    }

    public static void main(String[] args) {
        System.out.println(getBitwiseAndOfRange(5,7));
        System.out.println(getBitwiseAndOfRange(26, 30));
    }


}
