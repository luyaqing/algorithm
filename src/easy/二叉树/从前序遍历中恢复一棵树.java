package easy.二叉树;

import java.util.Stack;

/**
 * 输入的是前序遍历的顺序
 * 输出的是数组的遍历的顺序
 * Input: "1-2--3--4-5--6--7"
 * Output: [1,2,5,3,4,6,7]
 *
 * 解题思路：
 * 把树的结构路径放在Stack中。
 * 在一次循环中：
 * 我们得到数字的level，通过 "-"这个字符，
 * 我们得到数字的值，利用 String.charAt(i) - ‘0’  得到， 因为ASll 码表的数值得出。
 * 通过弹出stack中的数值，把该节点放到应该属于的位置。
 */
public class 从前序遍历中恢复一棵树 {

    public static void main(String[] args) {
        String s = "1-2--3--4-5--6--7";
        TreeNode node = recoverFromPreOrder(s);
        System.out.println(node.val);

        TreeNode node2 = recoverFromPreOrder_2(s);
        System.out.println(node2.val);
    }


    public static TreeNode recoverFromPreOrder(String S) {
        int level, val;
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < S.length();) {
            for (level = 0; S.charAt(i) == '-'; i++) {
                level++;
            }
            // 这个地方注意初始的条件是  val 先赋值，然后通过 i 进行循环
            // 如果 j 来循环，则会一直死循环在这里了。
            // 也可以 val = 0 拿掉，在定义的地方 val = 0，初始化一下即可
            for (val = 0; i < S.length() && S.charAt(i) != '-'; i++) {
                val = val * 10 + (S.charAt(i) - '0');
            }
            // 直接拿到父节点，
            while (stack.size() > level) {
                stack.pop();
            }
            TreeNode node = new TreeNode(val);
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            // 肯定要放入stack中，不然一个node都没有
            stack.add(node);
        }
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.pop();
    }

    public static TreeNode recoverFromPreOrder_2(String str) {
        int level, val;
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < str.length();) {     //  错点1： i++写在这里了

            // 确定level
            for (level = 0; str.charAt(i) == '-'; i++) {
                level++;
            }

            // 确定val的值
            for (val = 0; i < str.length() && str.charAt(i) != '-'; i++) {  // 错点2： 这里忘记了 i<str.length()的条件，并且这个条件要写在前面
                val = 10 * val + (str.charAt(i) - '0');
            }

            // 确定该值在树中的位置
            while (stack.size() > level) {
                stack.pop();
            }

            // 构造树形结构
            TreeNode node = new TreeNode(val);
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }

            } else {
                stack.push(node);
            }
        }

        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.pop();
    }
}

