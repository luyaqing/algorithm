package middle.动态规划;

/**
 * 小明在越南旅游，参加了当地的娱乐活动。小明运气很好，拿到了大奖， 到了最后的拿奖金环节。小明发现桌子上放着一列红包，每个红包上写着奖金数额。
 * 现在主持人给要求小明在这一列红包之间“切”2刀，将这一列红包“切”成3组，并且第一组的奖金之和等于最后一组奖金和（允许任意一组的红包集合是空）。
 * 最终第一组红包的奖金之和就是小明能拿到的总奖金。小明想知道最多能拿到的奖金是多少，你能帮他算算吗。
 *
 * 举例解释：桌子上放了红包  1, 2, 3, 4, 7, 10。小明在“4,7”之间、“7,10” 之间各切一刀，将红包分成3组 [1, 2, 3, 4]   [7]   [10]，
 * 其中第一组奖金之和=第三组奖金之和=10，所以小明可以拿到10越南盾。
 */
public class KS获得更多的奖金 {

    public static void main(String[] args) {
        System.out.println(getMaxBonus(6, new int[]{1, 2, 3, 4, 7, 10}));
    }

    // 很普通的思路， 两边往中间夹击就行
    public static int getMaxBonus(int n, int[] arr) {
        if (n == 0) {
            return 0;
        }

        if (arr.length == 0 || arr.length == 1) {
            return 0;
        }

        int max = 0;
        int left = 0;
        int right = arr.length - 1;
        int leftSum = 0;
        int rightSum = 0;

        while (left <= right) {
            if (leftSum > rightSum) {
                rightSum += arr[right];
                right--;
            }

            if (leftSum < rightSum) {
                leftSum += arr[left];
                left++;
            }

            if (leftSum == rightSum) {
                max = leftSum;
                leftSum += arr[left];
                left++;
            }
        }

        return max;
    }

}
