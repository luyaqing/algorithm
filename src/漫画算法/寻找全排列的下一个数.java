package 漫画算法;

import java.util.Arrays;

/**
 * @Description 寻找全排列的下一个数
 *    比如： 12345   12354  12435
 * @Author Hasee
 * @Date 2022/5/2 20:44
 * @Version 1.0
 */
public class 寻找全排列的下一个数 {

    public static int[] findNearestNumber(int[] numbers) {

        // 1. 从后往前查找到逆序对， 并找到逆序对前一位
        int index = findTransferPoint(numbers);

        if (index == 0) {
            return null;
        }

        // 2. 把逆序区域的前一位和区域中刚刚大于它的数字交换位置
        exchangeHead(numbers, index);

        // 把原来逆序区域变为顺序的
        reverse(numbers, index);
        return numbers;
    }

    private static void reverse(int[] numbers, int index) {
        for (int i = index, j = numbers.length - 1; i < j; i++, j--) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        return;
    }

    private static int[] exchangeHead(int[] numbersCopy, int index) {
        int head = numbersCopy[index - 1];
        for (int i = numbersCopy.length - 1; i > 0; i--) {
            if (head < numbersCopy[i]) {
                numbersCopy[index - 1] = numbersCopy[i];
                numbersCopy[i] = head;
                break;
            }
        }
        return numbersCopy;
    }


    private static int findTransferPoint(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i-1] < numbers[i]) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        for (int i = 0; i < 10; i++) {
            numbers = findNearestNumber(numbers);
            System.out.println(Arrays.toString(numbers));
        }
    }
}
