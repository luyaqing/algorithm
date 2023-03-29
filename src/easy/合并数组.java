package easy;

/**
 * @Description 阿里一面的算法， 面试的时候使用的三重for循环写的，但是这个效率太低了
 *      当时面试官给了我思路， 我还是没有写出来，非常的尴尬
 * @Author Hasee
 * @Date 2022/4/27 23:10
 * @Version 1.0
 */

/*
元素数组A=1,2,3,4 四个值，B=5,6 两个值，C=7,8 两个值，如何实现一个包含不同元素值的数组，比如：
[1,5,7]
[1,6,7]
*/
public class 合并数组 {

    public static int[][] results = new int[][]{};

    public static int[] result = new int[3];

    public static void getAllArrays(int[][] arr, int depth) {

        for (int i = 0; i < arr[depth].length; i++) {
            result[depth] = arr[depth][i];
            if (depth != arr.length - 1) {
                getAllArrays(arr, depth + 1);
            } else {
                for (int j = 0; j < result.length; j++) {
                    System.out.print(result[j]);
                }
                System.out.println();
            }

        }

    }

    public static void myTest(int[][] arr, int depth) {

        for (int i = 0; i < arr[depth].length; i++) {
            result[depth] = arr[depth][i];
            if (depth != arr.length - 1) {
                myTest(arr, depth + 1);
            } else {
                for (int i1 : result) {
                    System.out.print(i1);
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,3,4},
                {5,6},
                {7,8}};
       // getAllArrays(array, 0);

        myTest(array, 0);
    }
}
