package 漫画算法;

/**
 * @Description  1270936 删除7之后留下的数是最小的
 *        依次求得局部最优解， 最终得到全局最优解的思想， 叫做贪心算法
 *
 *        这道题的核心点在于： 如果发现某一位的数大于它右边的数，那么再删除该数字之后， 必然可以将该位的值降低，
 *        因为右边比他小的数字占据了它的位置
 * @Author Hasee
 * @Date 2022/5/2 21:10
 * @Version 1.0
 */
public class 删除K个数字之后的最小值 {

    public static String removeKDigits(String num, int k) {

        String numNew = num;
        for (int i = 0; i < k; i++) {
            boolean hasCut = false;

            // 从左往右遍历, 找到比自己右侧数字大的数字并删除
            for (int j = 0; j < numNew.length() - 1; j++) {
                if (numNew.charAt(j) > numNew.charAt(j + 1)) {
                    numNew = numNew.substring(0, j) + numNew.substring(j+1);
                    hasCut = true;
                    break;
                }
            }

            // 如果没找到数字，则删除数组中最后一个数字
            if (!hasCut) {
                numNew = numNew.substring(0, numNew.length() - 1);
            }

            // 清除左侧的数字0
            numNew = removeZero(numNew);
        }

        // 如果所有的数字都被删除了， 返回了
        if (numNew.length() == 0) {
            return "0";
        }

        return numNew;
    }

    private static String removeZero(String numNew) {
        for (int i = 0; i < numNew.length()-1; i++) {
            if (numNew.charAt(0) != '0') {
                break;
            }
            numNew = numNew.substring(1);
        }
        return numNew;
    }

    public static void main(String[] args) {
        System.out.println(removeKDigits("1593212", 3));
        System.out.println(removeKDigits("30200", 1));
        System.out.println(removeKDigits("10", 2));
    }

}
