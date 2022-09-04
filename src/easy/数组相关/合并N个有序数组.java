package easy.数组相关;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 合并N个有序的数组
 * @Author Hasee
 * @Date 2022/4/28 21:15
 * @Version 1.0
 */
public class 合并N个有序数组 {

    public static int[] mergeAll(ArrayList<int[]> lists, int l, int r){
        if(l >= r){
            return lists.get(l);
        }

        int m = (l + r) /2;
        int[] left = mergeAll(lists, l, m);
        int[] right = mergeAll(lists, m+1, r);
        return merge(left, right);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int m = 0;
        int n = 0;
        int[] mergeArr = new int[arr1.length + arr2.length];

        int i = 0;
        while (m < arr1.length || n < arr2.length) {
            if(m >= arr1.length){
                mergeArr[i++] = arr2[n++];
            } else if(n >= arr2.length){
                mergeArr[i++] = arr1[m++];
            } else if(arr1[m] < arr2[n]){
                mergeArr[i++] = arr1[m++];
            } else {
                mergeArr[i++] = arr2[n++];
            }
        }

        return mergeArr;
    }

    public static int[] mergeTwoSortedArray(int[] a, int[] b) {
        int length = a.length + b.length;
        int[] mergedArr = new int[length];
        int aIndex = a.length - 1;
        int bIndex = b.length - 1;
        int mergeIndex = length - 1;

        while (aIndex >= 0 && bIndex >= 0) {
            mergedArr[mergeIndex--] = a[aIndex] > b[bIndex] ? a[aIndex--] : b[bIndex--];
        }

        if (aIndex >= 0) {
            mergedArr[mergeIndex--] = a[aIndex--];
        }

        if (bIndex >= 0) {
            mergedArr[mergeIndex--] = b[bIndex--];
        }
        return mergedArr;
    }

    public static int[] mergeAll2(List<int[]> lists, int l, int r) {

        if (l == r) {
            return lists.get(l);
        }

        int m = (l + r) / 2;
        int[] left = mergeAll2(lists, l, m);
        int[] right = mergeAll2(lists, m+1, r);
        return mergeTwoSortedArray(left, right);
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,5,20};
        int[] arr2 = {2,4,6,8,10,12};
        int[] arr3 = {1,9,11};
        ArrayList<int[]> list = new ArrayList<>();
        list.add(arr1);
        list.add(arr2);
        list.add(arr3);
        int[] merge = mergeAll(list, 0, list.size() -1);
        System.out.println(Arrays.toString(merge));

        int[] merge2 = mergeAll2(list, 0, list.size() - 1);
        System.out.println(Arrays.toString(merge2));
    }
}
