package com.xiaou.tree;

import org.junit.Test;

/**
 * 线索二叉树
 * @author xiaou
 */
public class ClueTreeTest {
    private ClueTree tree;
    @Test
    public void addTeat() {
        tree = new ClueTree();
        tree.add(7);
        tree.add(3);
        tree.add(10);
        tree.add(12);
        tree.add(5);
        tree.add(1);
        tree.add(9);
    }
    @Test
    public void clueTest() {
        addTeat();
        tree.clue();
        tree.clueList();
    }
}
class ClueTree {
    private ClueTreeNode root;
    /**
     * 线索化时保留之前的一个节点
     */
    private ClueTreeNode prev = null;
    public void clue () {
        clue(root);
    }
    public void clueList() {
        ClueTreeNode node = root;
        while (node != null) {
            // 先遍历左节点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            System.out.println(node.getValue());
            // 如果有线索化的节点就一直输出
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node.getValue());
            }
            node = node.getRight();
        }
    }
    private void clue (ClueTreeNode node) {
        if (node == null) {
            return;
        }
        // 先左子树
        clue(node.getLeft());
        // 线索化当前节点
        if (node.getLeft() == null) {
            // 让当前节点的左指针指向前驱节点
            node.setLeft(prev);
            // 改变节点左节点的类型
            node.setLeftType(1);
        }          if (prev != null && prev.getRight() == null) {
            // 让前驱节点的右指针指向当前节点
            prev.setRight(node);
            // 改变前驱节点右节点的类型
            prev.setRightType(1);
        }
        // 保存这一次节点
        prev = node;
        // 线索化右子树
        clue(node.getRight());
    }
    public void add(int value) {
        // 第一次增加
        if (root == null) {
            root = new ClueTreeNode();
            root.setValue(value);
            return;
        }
        ClueTreeNode treeNode = new ClueTreeNode();
        treeNode.setValue(value);
        ClueTreeNode headTemp = root;
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
class ClueTreeNode {
    private ClueTreeNode right;
    private ClueTreeNode left;
    private int rightType;
    private int leftType;
    private int value;

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public ClueTreeNode getRight() {
        return right;
    }

    public void setRight(ClueTreeNode right) {
        this.right = right;
    }

    public ClueTreeNode getLeft() {
        return left;
    }

    public void setLeft(ClueTreeNode left) {
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