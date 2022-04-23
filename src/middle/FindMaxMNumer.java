package middle;

import java.util.Arrays;

/**
 * 找到数组中最大的m个数， 返回一个数组出来
 */
public class FindMaxMNumer {

    public static int[] getMaxMNumbers(int[] arr, int m) {
        if (m == 0 || arr.length == 0) {
            return new int[0];
        }

        return quickSearch(arr, 0, arr.length - 1, m - 1);
    }


    /**
     * 根据快排的思想对数组进行切分， 再根据基准pos判断继续切分左边还是右边的分区， 最终的结果是数组从0位置到m位置是最大的m个数
     * @param array 数组
     * @param start 起始位置
     * @param end  结束位置
     * @param mIndex m位置对应的数组的索引
     * @return
     */
    private static int[] quickSearch(int[] array, int start, int end, int mIndex) {
        // 找到基准点，如果刚好等于m， 就直接返回j左边的数组，(包括j位置)
        int j = partition(array, start, end);

        // 结束条件
        if (j == mIndex) {
            return Arrays.copyOf(array, j + 1);
        }

        // 如果不相等， 根据j和m的关系判断是切分左边还是右边
        return j > mIndex? quickSearch(array, start, j - 1, mIndex) : quickSearch(array, j + 1, end, mIndex);
    }


    /**
     * 对数组进行切分， 比j位置大的在j的左边， 小的在j的右边
     * @param array
     * @param start
     * @param end
     * @return
     */
    private static int partition(int[] array, int start, int end) {
        int pos = array[start];
        int i = start, j = end + 1;

        while (true) {
            while (++i <= end && array[i] > pos);
            while (--j >= start && array[j] < pos);

            if (i >= j) {
                break;
            }

            int t = array[j];
            array[j] = array[i];
            array[i] = t;
        }

        array[start] = array[j];
        array[j] = pos;
        return j;
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,9,8,7,4,6,3,10};
        int n = 4;
        int[] maxKNum = getMaxMNumbers(arr, n);
        for (int i : maxKNum) {
            System.out.println(i);
        }
    }

}
