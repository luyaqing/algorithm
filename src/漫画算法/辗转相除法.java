package 漫画算法;

/**
 * @Description 辗转相除法, 求最大公约数 a和b
 * @Author Hasee
 * @Date 2022/4/19 16:54
 * @Version 1.0
 */
public class 辗转相除法 {

    public static int getMaxDivisors(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;

        if (big % small == 0) {
            return small;
        }
        return getMaxDivisors(big % small, small);
    }

    public static void main(String[] args) {
        System.out.println(getMaxDivisors(100, 80));
    }
}
