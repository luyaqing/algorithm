package easy.字节相关;

/**
 *  Number of 1 Bits
 */
public class one_字节出现的次数 {

    public static void main(String[] args) {
        System.out.println(hammingWeight(0));
    }

    // 最简单的办法， 移动字节位
    public static int hammingWeight(int n) {
        int ones = 0;
        while (n != 0) {
            ones += (n & 1);
            n = n >>> 1;
        }
        return ones;
    }


}
