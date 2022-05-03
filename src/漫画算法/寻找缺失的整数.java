package 漫画算法;

import java.util.Arrays;

/**
 * @Description 寻找缺失的整数
 * @Author Hasee
 * @Date 2022/5/3 15:34
 * @Version 1.0
 */
public class 寻找缺失的整数 {

    /**
     * 在一个无序数组里有99个不重复的整数， 范围是1~100， 唯独缺少其中的一个整数， 求出来
     *
     * 解法一： 先算出1到100的和，然后进行遍历减去数组中的数，剩下的数就是缺失的数
     *
     * 问题扩展一：
     *      一个无序数组中有若干个正整数， 范围是1 - 100， 其中99个整数都出现了偶数次，只有一个整数出现了奇数次
     *      如何找到这个出现奇数次的整数？
     *
     *      解法：把数组中所有的数都进行异或运算，最终的值就是出现缺失的整数
     *
     *
     *  问题扩展二：
     *      如果数组中有两个整数出现了奇数次，其他的整数出现了偶数次，如何找到这两个整数呢？
     *      使用分治法
     *      循环异或运算之后，得到的数字是两个奇数次次数的值得异或结果， 这个值得某一位不为0说明两个整数在该位上是不一致的
     *      可以根据这个条件把原来的数据进行分组，两个出线奇数次的整数肯定是分别在两个数组中的，然后再进行上面的计算即可了
     */


    /**
     * 算法的实现
     */
    public static int[] findLostNumber(int[] array) {

        int[] result = new int[2];

        // 进行整体的异或运算
        int xorResult = 0;
        for (int i = 0; i < array.length; i++) {
            xorResult ^= array[i];
        }

        // 说明不存在的
        if (xorResult == 0) {
            return null;
        }

        // 确定两个整数的不同位，以此来进行分组
        int separator = 1;
        while (0 == (xorResult & separator)) {
            separator <<= 1;
        }

        // 第二次分组进行异或运算
        for (int i = 0; i < array.length; i++) {

            if (0 == (array[i] & separator)) {
                result[0] ^= array[i];
            } else {
                result[1] ^= array[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4,1,2,2,5,1,4,3};
        int[] result = findLostNumber(arr);
        System.out.println(Arrays.toString(result));
    }

}
