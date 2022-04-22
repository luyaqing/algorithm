package test;

import java.util.Arrays;

/**
 * @Description 合并有序数组, 排序好的
 * @Author Hasee
 * @Date 2022/4/19 19:40
 * @Version 1.0
 */
public class Test {

    public static int[] mergeSortedArray(int[] a,  int[] b) {
        int aLength = a.length;
        int bLength = b.length;

        int totalLength = aLength + - 1;
        while (bLength > 0) {
            a[totalLength] = a[aLength] > b[totalLength] ? a[aLength--] : b[bLength--];
        }

        return a;
    }

    public static int[] mergeSortedArray(int[] a, int m, int[] b, int n) {
        int aIndex = m - 1;
        int bIndex = n - 1;
        int index = m + n - 1;

        while (aIndex >= 0 && bIndex >= 0) {
            a[index--] = a[aIndex] > b[bIndex] ? a[aIndex--] : b[bIndex--];
        }

        while (bIndex > 0) {
            a[index--] = b[bIndex--];
        }
        return a;
    }

    // 测试
    public static void main(String[] args) {
        int[] A = new int[]{1,2,8,0,0,0,0};
        int aSize = 3;
        int[] B = new int[]{4,5,6,7};
        int bSize = 4;
        mergeSortedArray(A, aSize, B, bSize);

        System.out.println(Arrays.toString(A));
    }
}
