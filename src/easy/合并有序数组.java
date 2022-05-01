package easy;

import java.util.Arrays;

/**
 * @Description 合并两个有序的数组，其中A数组中容量是很大的， A、B两个数组都是有序的
 * @Date 2022/4/13 11:18
 * @Version 1.0
 */
public class 合并有序数组 {


    /**
     * 解题思路：  A和B数组是有序的， 需要借助这个条件的
     * 我刚开始的思路是： 两个for循环，煞笔
     *
     * 最直接的思路应该是： while循环， 新增一个数组， 然后while条件， 比较两个数组的值，谁的小，往里面塞，完事
     * 但是还是能优化的，因为A数组的空间是足够包容B的， 所以肯定是可以直接放到A中去的，不需要新建数组什么的，
     * 但是是有技巧的，因为如果从头开始遍历的话，会导致比较的时候，A数组的值被改了， 不行，所以应该从尾部开始倒着来，完美解决问题。
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void mergeSortArray(int[] A, int m, int[] B, int n) {

        int aIndex = m - 1;
        int bIndex = n - 1;
        int index = m + n - 1;

        while (aIndex >= 0 && bIndex >= 0) {
            A[index--] = A[aIndex] > B[bIndex] ?  A[aIndex--] : B[bIndex--];
        }

        // 这里为啥没有检查aIndex， 是因为已经是有序的了， 并不需要检查A的内容了
        while (bIndex >= 0) {
            A[index--] = B[bIndex--];
        }
    }

    /**
     * 这个是新建一个数组的解法
     * @param a
     * @param b
     * @return
     */
    public static int[] mergeTwoSortedArray(int[] a, int[] b) {
        int length = a.length + b.length;
        int[] mergedArr = new int[length];

        int aIndex = a.length - 1;
        int bIndex = b.length - 1;
        int mergeIndex = length - 1;

        while (aIndex >= 0 && bIndex >= 0) {
            mergedArr[mergeIndex--] = a[aIndex] > b[bIndex] ? a[aIndex--] : b[bIndex--];
        }

        while (aIndex >= 0) {
            mergedArr[mergeIndex--] = a[aIndex--];
        }

        while (bIndex >= 0) {
            mergedArr[mergeIndex--] = b[bIndex--];
        }
        return mergedArr;
    }

    public static void main(String[] args) {

        int[] A = new int[]{1,2,8,0,0,0,0};
        int aSize = 3;
        int[] B = new int[]{4,5,6,7};
        int bSize = 4;
        mergeSortArray(A, aSize, B, bSize);
        System.out.println(Arrays.toString(A));

        int[] A2 = new int[]{1,2,8};
        int[] B2 = new int[]{4,5,6,7};
        int[] mergeArray = mergeTwoSortedArray(A2, B2);
        System.out.println(Arrays.toString(mergeArray));
    }
}
