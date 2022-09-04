package easy.字节相关;

/**
 * Input: n = 00000010100101000001111010011100  (43261596)
 * Output:    964176192 (00111001011110000010100101000000)
 */

public class 翻转32位二进制 {

    public static void main(String[] args) {

        System.out.println(reverseBits(43261596));
        System.out.println(reverseBits_2(43261596));
    }

    // 简单的算法： 左右开工
    public static int reverseBits(int n) {

        if (n == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += n & 1;
            n >>= 1;
        }

        return result;
    }

    public static int reverseBits_2(int n) {

        if (n == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= n & 1;   //  为什么这么可以使用这样的运算，是因为result的末尾肯定是0，上一步 << 了
            n >>= 1;
        }
        return result;
    }
}
