package 面试遇到的;


import java.util.HashSet;
import java.util.Set;

/**
 * 举例说明
 * n = 91
 * 计算过程
 * 1：  9^2 + 1^2 = 81 + 1 = 82
 * 2:   8^2 + 2^2 = 64 + 4 = 68
 * 3:   6^2 + 8^2 = 36 + 64 = 100
 * 4：  1^2 + 0^2 + 0^2 = 1 + 0 + 0 = 1
 * 所以返回true
 */
public class 计算每一位的和相加为1 {

    public static void main(String[] args) {
        System.out.println(calculate(90));
    }

    public static boolean calculate(int sum) {

        // 缓存对象
        Set resultSet = new HashSet<>();
        resultSet.add(sum);

        // 计算每一位的数值
        int result = getSumEachIndex(sum);
        resultSet.add(result);

        while(!isRight(result)) {

            result = getSumEachIndex(result);

            // 如果存在表示会死循环，直接return false
            if (resultSet.contains(result)) {

                return false;

            } else {

                resultSet.add(result);

            }
        }

        return true;
    }

    // 是否符合条件
    public static boolean isRight(int result) {
        return result == 1;
    }

    //  计算每一位的和
    public static int getSumEachIndex(int a) {

        int sum = 0;
        while( a != 0 ){
            sum += Math.pow(a % 10,  2);
            a = a / 10;
        }
        return sum;
    }
}
