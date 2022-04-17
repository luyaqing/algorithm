package middle;

/**
 * （）（）相关的算法题
 */
public class Code03_ParenthesesDeep {

	// 判断一个字符串是否有效
	public static boolean isValid(char[] str) {
		if (str == null || str.length == 0) {
			return false;
		}
		int status = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] != ')' && str[i] != '(') {
				return false;
			}
			if (str[i] == ')' && --status < 0) {
				return false;
			}
			if (str[i] == '(') {
				status++;
			}
		}
		return status == 0;
	}

	/**
	 * 求 （（）（）） 中最高嵌套了几层
	 *
	 * 思路： 遇到（ count ++
	 * 		 遇到 ）count --
	 * 		 当count达到最大值的时候就是几层
	 *
	 * @param s
	 * @return
	 */
	public static int deep(String s) {
		char[] str = s.toCharArray();
		if (!isValid(str)) {
			return 0;
		}
		int count = 0;
		int max = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == '(') {
				max = Math.max(max, ++count);
			} else {
				count--;
			}
		}
		return max;
	}


	/**
	 * 求一个字符串中有效括号的最大长度是多少?
	 *    运用的是DP： 动态规划的解题思路
	 *
	 * 我默写的代码
	 * @param s
	 * @return
	 */
	public static int getMaxLength(String s) {
		if (s == null || s.equals("")) {
			return 0;
		}
		int res = 0;
		int pre = 0;
		char[] chars = s.toCharArray();
		int[] dp = new int[chars.length];
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == ')') {
				pre = i - dp[i-1] - 1;  // 找到前一个"("的位置， 需要跨过n-1的长度
				if (pre >= 0 && chars[pre] == '(') {
					dp[i] = dp[i-1] + 2 + (pre - 1 > 0 ? dp[pre -1] : 0);
				}
			}
			res = Math.max(dp[i], res);
		}

		return res;
	}
	public static int maxLength(String s) {
		if (s == null || s.equals("")) {
			return 0;
		}
		char[] str = s.toCharArray();
		int[] dp = new int[str.length];
		int pre = 0;
		int res = 0;
		for (int i = 1; i < str.length; i++) {
			if (str[i] == ')') {
				pre = i - dp[i - 1] - 1; // 与str[i]配对的左括号的位置 pre
				if (pre >= 0 && str[pre] == '(') {
					dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		String test = "((()))()";
		System.out.println(getMaxLength(test));

	}

}
