package middle;

/**
 * 有效括号相关算法，有很多的变种形式
 *
 *  1、给定一个只包括 '('，')'的字符串，判断字符串是否有效。注：空字符串属于有效字符串
 *
 *  2、最长有效括号
 *
 *
 */
public class 有效括号 {


    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidNumber(s));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }

        int n = s.length();
        int sum = 0;
        for (int i = 0; i <n ; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                sum++;
            } else {

                // 这一步很重要， 如果是0了表示，) 开始的， 肯定是不合法的，所以在这里直接返回false了
                if (sum == 0) {
                    return false;
                } else {
                    sum--;
                }
            }
        }

        return sum == 0 ? true : false;
    }

    public static int longestValidNumber(String s) {
        int left = 0;
        int right = 0;
        int max = 0;

        // 从左到右
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                max = Math.max(max, 2 * left);
            } else if (right > left) {
                left = right = 0;
            }
        }

        left = right = 0;  //  易错点： 这里一定要初始化一下， 不然下面的遍历会出问题啊

        // 从右到左
        for (int i = s.length()-1; i >= 0; i--) {   //  易错点：从右向左的话，记得i要从右到左进行遍历。
            if (s.charAt(i) == ')') {
                right++;
            } else {
                left++;
            }

            if (left == right) {
                max = Math.max(max, 2 * left);
            } else if (left > right){
                left = right = 0;
            }
        }
        return max;
    }


}
