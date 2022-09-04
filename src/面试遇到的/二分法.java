package 面试遇到的;

/**
 * @Description 是一个典型的二分法;
 * @Author Hasee
 * @Date 2022/4/11 12:16
 * @Version 1.0
 *
 * 给定一个n元素有序的（升序）整型数组nums 和一个目标值target，写一个函数搜索nums中的 target，
 * 如果目标值存在返回下标，否则返回 -1。
 *
 *
 */
public class 二分法 {

    public static int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        // 我的易错点： while(low < high) 这样是不对的， 1 2 3 的时候会出错， mid + 1  = high了, 跳出循环了。
        // 只能这么写合适，因为low的值会一直逼近最右端的
        // 出错+1
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
