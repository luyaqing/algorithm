package easy;

import 漫画算法.BitMap的巧用;

import java.util.Arrays;

/**
 * some demo ： 合并两个有序的数组， 都是递增的
 */
public class epoch_test {

    public static void main(String[] args) {
        int[] A = new int[]{1,2,8,0,0,0,0};
        int aSize = 3;
        int[] B = new int[]{4,5,6,7};
        int bSize = 4;
        mergeSortedArray(A, 3, B, 4);
        System.out.println(Arrays.toString(A));

        System.out.println("-------------------");
        int[] A2 = new int[]{1,2,8};
        int[] B2 = new int[]{4,5,6,7};
        int[] mergeArray = mergeSortedArray2(A2, B2);
        System.out.println(Arrays.toString(mergeArray));
    }

    // 全部放在A数组中的情况
    public static int[] mergeSortedArray(int[] arr1, int m, int[] arr2, int n){

        int total = m + n - 1;
        int aIndex = m-1;
        int bIndex = n-1;

        while (aIndex >= 0 && bIndex >= 0) {
            arr1[total--] = arr1[aIndex] > arr2[bIndex] ? arr1[aIndex--] : arr2[bIndex--];
        }


        while (bIndex >= 0)  {
            arr1[total--] = arr2[bIndex--];
        }

        return arr1;
    }


    public static int[] mergeSortedArray2(int[] arr1, int[] arr2){

        int length = arr1.length + arr2.length;
        int[] result = new int[length];

        int aIndex = arr1.length - 1;
        int bIndex = arr2.length - 1;
        int mergeIndex = length - 1;

        while (aIndex >= 0 && bIndex >= 0) {
            result[mergeIndex--] = arr1[aIndex] > arr2[bIndex] ? arr1[aIndex--] : arr2[bIndex--];
        }


        while (bIndex >= 0)  {
            result[mergeIndex--] = arr2[bIndex--];
        }

        while (aIndex >= 0) {
            result[mergeIndex--] = arr1[aIndex--];
        }

        return result;
    }
}
