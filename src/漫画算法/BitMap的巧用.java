package 漫画算法;

/**
 * @Description Bitmap的巧用
 * @Author Hasee
 * @Date 2022/5/3 16:15
 * @Version 1.0
 */
public class BitMap的巧用 {

    /**
     * 用户存在很多的标签，这个对应关系如何有好的存储才对
     *
     * 使用位图算法， 让一个标签对应多个用户，bitmap中存储的是用户的ID即可， 就像倒排索引一样。
     * 每一个标签都是一个独立的bitmap
     *
     * 为啥不适用哈希表来实现用户的去重和统计操作， 为什么一定要使用bitmap呢？
     *      如果使用哈希表的话， 每一个用户id都要存储成int或者long类型， 少则占用4字节，多则占用8字节（64bit）
     *      而一个用户id在Bitmap中只占1bit， 内存是使用哈希表的内存的1 / 32， 甚至更少。
     *      不仅如此， BitMap在对用户群做交集和并集运算时也有极大的便利， 使用位运算即可。 另一个优势：高性能的位运算
     *
     * 注意点： 如何找到非 “90后”的用户， 并不是简单的取反操作。
     *    解决这个问题可以借助全量的Bitmap， 不存在于 “90后” 但是存在于 全量中的记录即可， 两个bitMap进行异或运算即可
     */


    /**
     * 代码如何实现？
     */

    // 每一个word是一个long类型元素， 对应一个64位二进制数据
    private long[] words;
    // BitMap的位数大小
    private int size;

    public BitMap的巧用(int size) {
        this.size = size;
        this.words = new long[(getWordIndex(size-1) + 1)];

    }

    /**
     * 判断Bitmap某一位的状态
     * @param bitIndex 位图的第bitIndex位 (bitIndex = 0 表示Bitmap左数第一位)
     * @return
     */
    public boolean getBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("超出BitMap有效的范围");
        }

        int wordIndex = getWordIndex(bitIndex);
        return (words[wordIndex] & (1L << bitIndex)) != 0;
    }

    /**
     * 设置BitMap某一位为true
     * @param bitIndex
     */
    public void setBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("超出BitMap有效的范围");
        }

        int wordIndex = getWordIndex(bitIndex);
        words[wordIndex] |= (1L << bitIndex);
    }


    /**
     * 定位bitMap某一位所对应的word
     * @param bitIndex 位图的第bitIndex位 (bitIndex = 0 表示Bitmap左数第一位)
     * @return
     */
    private int getWordIndex(int bitIndex) {
        // 右移6位， 相当于除以64
        return bitIndex >> 6;
    }

    public static void main(String[] args) {
        BitMap的巧用 bitMap = new BitMap的巧用(128);
        bitMap.setBit(126);
        bitMap.setBit(75);
        System.out.println(bitMap.getBit(126));
        System.out.println(bitMap.getBit(75));
        System.out.println(bitMap.getBit(78));
    }
}
