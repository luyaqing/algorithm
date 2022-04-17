package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 求数组的子数组， 包含空数组
 * @Author Hasee
 * @Date 2022/4/11 10:31
 * @Version 1.0
 */
public class SubSets {


    public static List<List<Integer>> subSets (int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3};

        System.out.println(subSets(arr));
    }
}
