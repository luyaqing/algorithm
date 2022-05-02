package 漫画算法;

/**
 * @Description 实现两个大整数相加
 * @Author Hasee
 * @Date 2022/5/2 23:16
 * @Version 1.0
 */
public class 大整数相加 {

    public static String bigNumberSum(String bigNumberA, String bigNumberB) {

        int maxLength = bigNumberA.length() > bigNumberB.length() ? bigNumberA.length() : bigNumberB.length();

        int[] arrA = new int[maxLength + 1];
        for (int i = 0; i < bigNumberA.length(); i++) {
            arrA[i] = bigNumberA.charAt(bigNumberA.length() - 1 - i) - '0';
        }

        int[] arrB = new int[maxLength + 1];
        for (int i = 0; i < bigNumberB.length(); i++) {
            arrB[i] = bigNumberB.charAt(bigNumberB.length() - 1 - i) - '0';
        }

        int[] result = new int[maxLength + 1];

        // 遍历数组，按位相加
        for (int i = 0; i < result.length; i++) {
            int temp = result[i];
            temp += arrA[i];
            temp += arrB[i];

            if (temp > 10) {
                temp = temp - 10;
                result[i+1] = 1;
            }
            result[i] = temp;
        }

        // 再逆序进行输出即可
        StringBuilder sb = new StringBuilder();

        // 是否找到大整数的最高的有效位
        boolean findFirst = false;
        for (int i = result.length-1; i >= 0; i--) {
            if (!findFirst) {
                if (result[i] == 0) {
                    continue;
                }
                findFirst = true;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(bigNumberSum("121", "12"));
    }
}
