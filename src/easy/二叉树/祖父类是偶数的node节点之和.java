package easy.二叉树;

/**
 * 二维数组构造的树形结构， 找到祖父是偶数的node节点之和
 */
public class 祖父类是偶数的node节点之和 {

    public static void main(String[] args) {

    }

    public static int sumEvenGrandParent(TreeNode root) {
        return calculateNum(root, 1, 1);
    }

    private static int calculateNum(TreeNode node, int p, int gp) {
        if (node == null) {
            return 0;
        }

        return calculateNum(node.left, node.val, p) + calculateNum(node.right, node.val, p)
                + (gp % 2 == 0 ? node.val : 0);
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
