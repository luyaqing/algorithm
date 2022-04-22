package 漫画算法;

/**
 * @Description 是否是2的n次幂
 * @Author Hasee
 * @Date 2022/4/19 17:20
 * @Version 1.0
 */
public class n次幂 {

    public static boolean isPowerOf2(int num) {
        return (num & num -1) == 0;
    }
}
