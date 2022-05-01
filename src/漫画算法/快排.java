package 漫画算法;

import java.util.Arrays;

/**
 * @Description 快速排序： 双边循环和单边循环， 这个是双边循环的实现
 * @Author Hasee
 * @Date 2022/5/1 21:24
 * @Version 1.0
 */
public class 快排 {

    // 双边循环法
    public static void quickSearch(int[] arr, int startIndex, int endIndex) {
        // 结束条件
        if (startIndex >= endIndex) {
            return;
        }

        // 得到基准位置
        int pivotIndex = partition(arr, startIndex, endIndex);

        // 根据基准位置进行排序
        quickSearch(arr, startIndex, pivotIndex - 1);
        quickSearch(arr, pivotIndex + 1, endIndex);
    }

    public static int partition(int[] arr, int startIndex, int endIndex) {

        // 选择基准的位置
        int pivot =  arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {

            // 控制right指针比较并左移
            while (left < right && arr[right] > pivot) {
                right--;
            }
            // 控制left指针比较并右移
            while (left < right && arr[left] <= pivot) {
                left++;
            }

            // 交换left和right指针所指向的元素
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }

        // pivot和指针重合点进行交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,4,6,5,3,2,8,1};
        quickSearch(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
