package middle;

import java.util.ArrayList;
import java.util.List;

public class 求数组所有的子数组 {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3};
        System.out.println(subSets(array));
    }

    // 回溯的解法， 先从一个路径全部找全，再重新回来进行查找（二分法）
    public static List<List<Integer>> subSets (int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backTrace(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }

    private static void backTrace(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));   // 易错点： 必须是深拷贝才可以，不然tempList的最终的值肯定是空的
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backTrace(list, tempList, nums, i+1);   // 易错点： 这个地方是i+1, 而不是start+1,   start只是起始的值
            tempList.remove(tempList.size() - 1);
        }
    }

}
