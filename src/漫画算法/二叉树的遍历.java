package 漫画算法;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Description 二叉树的遍历 - 基本操作
 * @Author Hasee
 * @Date 2022/4/19 15:08
 * @Version 1.0
 */
public class 二叉树的遍历 {

    /**
     * 构建二叉树
     * @param inputList
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }

        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftNode = createBinaryTree(inputList);
            node.rightNode = createBinaryTree(inputList);
        }

        return node;
    }

    /**
     * 前序遍历
     */
    public static void preOrderTraveral(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.data);
        preOrderTraveral(treeNode.leftNode);
        preOrderTraveral(treeNode.rightNode);
    }

    /**
     * 中序遍历
     */
    public static void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraveral(node.leftNode);
        System.out.println(node.data);
        inOrderTraveral(node.rightNode);
    }

    /**
     * 后续遍历
     */
    public static void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrderTraveral(node.leftNode);
        postOrderTraveral(node.rightNode);
        System.out.println(node.data);
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList =
                new LinkedList<>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
        TreeNode treeNode = createBinaryTree(inputList);

        System.out.println("前序遍历");
        preOrderTraveral(treeNode);

        System.out.println("中序遍历");
        inOrderTraveral(treeNode);

        System.out.println("后序遍历");
        postOrderTraveral(treeNode);

    }


    private static class TreeNode {
        int data;
        TreeNode leftNode;
        TreeNode rightNode;
        TreeNode(int data) {
            this.data = data;
        }
    }
}
