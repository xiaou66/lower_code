package com.xiaou.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xiaou
 */
public class HuffmanTree {
    int arr[] = {13,7,8,3,29,6,1};
    @Test
    public void huffmanTest() {
        HuffmanNode huffmanTree = createHuffmanTree(arr);
        // 前序遍历
        huffmanTree.PreOrder();
    }

    /**
     * 创建哈夫曼树
     * @param arr  哈夫曼树的数组
     * @return 哈夫曼树的根节点
     */
    public HuffmanNode  createHuffmanTree(int[] arr) {
        List<HuffmanNode> huffmanNodes = new ArrayList<HuffmanNode>();
        for (int i = 0; i < arr.length; i++) {
            huffmanNodes.add(new HuffmanNode(arr[i]));
        }
        while (huffmanNodes.size() > 1) {
            Collections.sort(huffmanNodes);
            // 取出第一二小的数 然后相加形成新的二叉树
            HuffmanNode leftNode = huffmanNodes.get(0);
            HuffmanNode rightNode = huffmanNodes.get(1);
            HuffmanNode parent = new HuffmanNode(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            // 从集合中删除处理过的二叉树
            huffmanNodes.remove(leftNode);
            huffmanNodes.remove(rightNode);
            // 将 parent 加入到 nodes
            huffmanNodes.add(parent);
        }
        // 返回哈夫曼树的 root 节点
        return huffmanNodes.get(0);
    }
}
class HuffmanNode implements Comparable<HuffmanNode> {
    /**
     * 字符
     */
    char c;
    /**
     * 权值
     */
    int value;
    /**
     * 指向左子节点
     */
    HuffmanNode left;
    /**
     * 指向右子节点
     */
    HuffmanNode right;
    public void PreOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.PreOrder();
        }
        if (this.right !=null ){
            this.right.PreOrder();
        }
    }
    public HuffmanNode(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
