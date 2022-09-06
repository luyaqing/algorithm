package middle;

public class 区间内按位与预算 {

    public static void main(String[] args) {
        System.out.println(rangeBitWiseAnd(5, 7));
        System.out.println(rangeBitWiseAnd(0, 1));
    }


    /**
     *  思路: m和n不相等的时候， 中间肯定是有不同值得，比如奇数和偶数，那么&运算肯定是0， 所以直接位运算到相等时，
     *       此时位运算之后等于本身，然后相应的右移回去对应的位数即可
     */
    public static int rangeBitWiseAnd(int m, int n) {
        int count = 0;
        while(m != n) {

            m >>= 1;
            n >>= 1;
            count++;
        }
        return m << count;  //  易错点： 这里不要搞反了
    }
}
