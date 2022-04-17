package middle;


public class Code04_ColorLeftRight {

	/**
	 *   RGRGR -> RRRGG
	 *   左边全是R， 右边全是G， 求最小的修改的次数
	 *
	 * @param s
	 * @return
	 */

	public static int myMinPaint(String s) {
		if (s == null || s.length() < 2) {
			return 0;
		}
		int rAll = 0;
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			rAll += chars[i] == 'R' ? 1 : 0;
		}

		int res = rAll;  // 如果数组都是右侧范围，那么都变成G， 此时是不需要染色的， GGGGG这种极端
		int gLeft = 0;
		for (int i = 0; i < chars.length; i++) {
			gLeft += chars[i] == 'G' ? 1 : 0;
			rAll -= chars[i] == 'R' ? 1 : 0;

			res = Math.min(res, rAll +  gLeft);
		}

		// 这种处理是为了避免 RRRRRR这种极端； 至此两个极端都解决了，完美
		return Math.min(res, gLeft + (chars[chars.length - 1] == 'G' ? 1 : 0));
	}


	public static int minPaint(String s) {
		if (s == null || s.length() < 2) {
			return 0;
		}
		char[] chs = s.toCharArray();
		int[] right = new int[chs.length];
		right[chs.length - 1] = chs[chs.length - 1] == 'R' ? 1 : 0;
		for (int i = chs.length - 2; i >= 0; i--) {
			right[i] = right[i + 1] + (chs[i] == 'R' ? 1 : 0);
		}
		int res = right[0];
		int left = 0;
		for (int i = 0; i < chs.length - 1; i++) {
			left += chs[i] == 'G' ? 1 : 0;
			res = Math.min(res, left + right[i + 1]);
		}
		res = Math.min(res, left + (chs[chs.length - 1] == 'G' ? 1 : 0));
		return res;
	}

	public static void main(String[] args) {
		String test = "RRRRG";
		System.out.println(minPaint(test));

		System.out.println(myMinPaint(test));

	}

}
