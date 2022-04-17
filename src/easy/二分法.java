package easy;

/**
 * @Description 是一个典型的二分法;
 * @Author Hasee
 * @Date 2022/4/11 12:16
 * @Version 1.0
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，
 * 如果目标值存在返回下标，否则返回 -1。
 *
 *
 */
public class 二分法 {

    public static int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low < nums.length - 1) {
            int mid = (low + high) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(arr, target));
    }

}
