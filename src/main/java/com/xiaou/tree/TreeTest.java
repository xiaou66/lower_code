package com.xiaou.tree;

import org.junit.Test;

import java.util.Stack;

/**
 * @author xiaou
 */
public class TreeTest {
    private Tree tree;
    @Test
    public void addTeat() {
        tree = new Tree();
        tree.add(7);
        tree.add(3);
        tree.add(10);
        tree.add(12);
        tree.add(5);
        tree.add(1);
        tree.add(9);
    }
    @Test
    public void preorderTest() {
        addTeat();
        tree.preorder();
    }
    @Test
    public void infixTest() {
        addTeat();
        tree.infix();
    }
    @Test
    public void postorder() {
        addTeat();
        tree.postorder();
    }
}
class Tree {
    private TreeNode head;
    public void preorder() {
        preorderTraversalRecursive(head);
    }
    public void infix() {
        infixTraversalRecursive(head);
        System.out.println("----------");
        infixTraversal(head);
    }
    public void postorder() {
        postorderTraversalRecursive(head);
        System.out.println("----------");
        postorderTraversal(head);
    }
    /**
     * 先序遍历 (非递归)
     * 根左右
     * @param root 根节点
     */
    private void preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            // 存在 根节点 开始循环
            TreeNode node = stack.pop();
            System.out.println(node.getValue());
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
    }
    /**
     * 中序遍历 (非递归)
     * 左根右
     * @param root 根节点
     */
    private void infixTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (!stack.empty()  || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.getLeft();
            }else{
                node = stack.pop();
                System.out.println(node.getValue());
                node = node.getRight();
            }
        }
    }
    /**
     * 后序遍历 (非递归)
     * 左右根
     * @param root 根节点
     */
    private void postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        TreeNode node = root;
        stack1.push(root);
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
            if (stack2.peek().getLeft() != null) {
                stack1.push(stack2.peek().getLeft());
            }
            if (stack2.peek().getRight() != null) {
                stack1.push(stack2.peek().getRight());
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().getValue());
        }

    }
    /**
     * 先序遍历 (递归)
     * @param node 节点
     */
    private void preorderTraversalRecursive(TreeNode node) {
        System.out.println(node.getValue());
        if (node.getLeft() != null) {
            // 向左子树递归
            preorderTraversal(node.getLeft());
        }
        if (node.getRight() != null) {
            // 向右子树递归
            preorderTraversal(node.getRight());
        }
    }
    /**
     * 中序遍历 (递归)
     * @param node 节点
     */
    private void infixTraversalRecursive(TreeNode node) {
        if (node.getLeft() != null) {
            // 向左子树递归
            infixTraversalRecursive(node.getLeft());
        }
        System.out.println(node.getValue());
        if (node.getRight() != null) {
            // 向右子树递归
            infixTraversalRecursive(node.getRight());
        }
    }
    /**
     * 后序遍历 (递归)
     * @param node 节点
     */
    private void postorderTraversalRecursive(TreeNode node) {
        if (node.getLeft() != null) {
            // 向左子树递归
            postorderTraversalRecursive(node.getLeft());
        }
        if (node.getRight() != null) {
            // 向右子树递归
            postorderTraversalRecursive(node.getRight());
        }
        System.out.println(node.getValue());
    }
    public void add(int value) {
        // 第一次增加
        if (head == null) {
            head = new TreeNode();
            head.setValue(value);
            return;
        }
        TreeNode treeNode = new TreeNode();
        treeNode.setValue(value);
        TreeNode headTemp = head;
        while (true) {
            if (headTemp.getValue() > treeNode.getValue()) {
                if (headTemp.getLeft() == null) {
                    headTemp.setLeft(treeNode);
                    break;
                }else {
                    headTemp = headTemp.getLeft();
                }
            }else {
                if (headTemp.getRight() == null) {
                    headTemp.setRight(treeNode);
                    break;
                }else {
                    headTemp = headTemp.getRight();
                }
            }
        }
    }

}
class TreeNode {
    private TreeNode right;
    private TreeNode left;
    private int value;

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }
}
