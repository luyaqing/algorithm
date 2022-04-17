package middle;

import java.util.*;

/**
 * @Description 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 虽然这个算法比较菜， 还是至少比没有实现的好
 * @Author Hasee
 * @Date 2022/4/11 22:38
 * @Version 1.0
 */

public class Generate_Parentheses {

    public static List<String> generateParenthesis(int n) {
        if (n == 1) {
            return Arrays.asList("()");
        }
        Set<String> hs = new HashSet<>();
        for (String s : generateParenthesis(n-1)) {
            for (int i = 0; i < 2*n-2; i++) {
                hs.add(s.substring(0,i) + "()" + s.substring(i, s.length()));
            }
        }
        return new ArrayList(hs);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
