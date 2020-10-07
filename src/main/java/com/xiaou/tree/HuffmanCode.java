package com.xiaou.tree;

import javafx.scene.transform.Rotate;
import org.junit.Test;

import java.util.*;

/**
 * 赫夫曼编码
 * @author xiaou
 */
public class HuffmanCode {
    @Test
    public void huffmanCodeTest() {
        // 011
        String content = "zjj";
        byte[] contentBytes = content.getBytes();
        byte[] bytes = huffmanZip(contentBytes);
        System.out.println(Arrays.toString(bytes));
        byte[] decode = decode(huffmanCodeMap, bytes);
        System.out.println(new String(decode));
    }

    private byte[] huffmanZip(byte [] bytes) {
        List<HuffmanCodeNode> nodes = getNodes(bytes);
        // 获取赫夫曼编码
        HuffmanCodeNode root = createHuffmanTree(nodes);
        Map<Byte, String> huffmanCodeMap = getCodes(root);
        System.out.println(huffmanCodeMap);
        // 获取赫夫曼编码字节数组
        byte[] zip = zip(bytes, huffmanCodeMap);
        return zip;
    }
    /**
     * 解码
     * @param huffmanCodeMap 赫夫曼编码表
     * @param huffmanBytes 赫夫曼编码得到的字节数组
     * @return 原来字符串对应的字节数组
     */
    private byte[] decode(Map<Byte, String> huffmanCodeMap, byte[] huffmanBytes) {
        // 1. 先 huffmanBytes 二进制的字符串
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < huffmanBytes.length;i++) {
           boolean flag = (i == huffmanBytes.length -1);
           stringBuffer.append(byteToBitString(!flag, huffmanBytes[i]));
        }
        // 把字符串按照指定的赫夫曼编码表进行解码
        // 赫夫曼编码表进行 key value 调换
        Map<String, Byte> map = new HashMap<String, Byte>();
        for (Map.Entry<Byte, String> entry : huffmanCodeMap.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        // 存放一个byte
        List<Byte> list = new ArrayList<Byte>();
        // 扫描二进制字符串
        for (int i = 0; i < stringBuffer.length();) {
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {
                // i 不动 让 count 移动, 指定匹配到一个字符
                String key;
                if (i + count > stringBuffer.length()) {
                    key = stringBuffer.substring(i);
                }else {
                    key = stringBuffer.substring(i, i + count);
                }
                b = map.get(key);
                if (b == null) {
                    count ++;
                }else {
                    // 匹配到
                    flag = false;
                }
            }
            list.add(b);
            // i 移动到匹配二进制之后位置继续匹配
            i += count;
        }
        byte [] b = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    /**
     * 将一个 byte 转换成一个二进制的字符串
     * @param flag 标志是否需要补高位, 如果是最后一个字节就不需要补高位
     * @param b byte
     * @return 二进制字符串
     */
    private String byteToBitString(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            // 按位与 1 0000 0000 | 0000 0001 => 1 0000 0001
            temp |= 256;
        }
        // 返回 temp 对应二进制的补码
        String str = Integer.toBinaryString(temp);
        if (flag || temp < 0) {
            return str.substring(str.length() - 8);
        }else {
            return str;
        }
    }
    /**
     * 将字符串对应的 byte[], 通过生成的赫夫曼编码表,返回一个赫夫曼编码 byte[]
     * @param bytes 原始字符串对应的 byte[]
     * @param huffmanCodeMap 赫夫曼编码对应表
     * @return 赫夫曼编码 byte[]
     */
    private byte[] zip (byte [] bytes, Map<Byte, String> huffmanCodeMap) {
        // 1. 利用 huffmanCodeMap 将 bytes 转换 赫夫曼编码对应字符串
        StringBuilder stringBuffer = new StringBuilder();
        // 遍历 bytes
        for (byte b : bytes) {
            stringBuffer.append(huffmanCodeMap.get(b));
        }
        // 统计 返回赫夫曼编码 byte[] 长度
        int len;
        // len = （stringBuffer.length() + 7） / 8;
        if (stringBuffer.length() > 8) {
            if (stringBuffer.length() % 8 == 0) {
                len = stringBuffer.length() / 8;
            } else {
                len = stringBuffer.length() / 8 + 1;
            }
        }else {
            len = stringBuffer.length();
        }
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuffer.length(); i += 8) {
            String strByte;
            if (i + 8 > stringBuffer.length()) {
                strByte = stringBuffer.substring(i);
            }else {
                strByte = stringBuffer.substring(i, i + 8);
            }
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }
    /**
     * 生成赫夫曼树对应的赫夫曼编码
     *  1. 将赫夫曼编码表存放到 Map<Byte, String> 中
     *     32 -> 01 97 -> 100
     *  2. 在生成赫夫曼编码表时需要去拼接路径，定义一个 StringBuilder 存储某个叶子节点的路径
     */
    private Map<Byte, String> huffmanCodeMap = new HashMap<Byte, String>();
    private StringBuffer stringBuffer = new StringBuffer();
    private Map<Byte, String> getCodes(HuffmanCodeNode root) {
        if (root == null) {
            return null;
        }
        getCodes(root.left, "0", stringBuffer);
        getCodes(root.right, "1", stringBuffer);
        return huffmanCodeMap;
    }
    /**
     * 获取传入的 node 节点所有叶子节点的赫夫曼编码，并放入到 huffmanCodeMap 集合中
     * @param node 传入节点
     * @param code 路径：左子节点 0,右子节点 1
     * @param stringBuffer 用于拼接路径
     */
    private void getCodes(HuffmanCodeNode node, String code, StringBuffer stringBuffer) {
        StringBuffer stringBuffer2 = new StringBuffer(stringBuffer);
        // 将 code 加入到 stringBuffer2
        stringBuffer2.append(code);
        if (node != null) {
            if (node.data == null) {
                // 非叶子节点
                // 向左递归
                getCodes(node.left, "0", stringBuffer2);
                // 向右递归
                getCodes(node.right, "1", stringBuffer2);
            }else{
                // 叶子节点
                huffmanCodeMap.put(node.data, stringBuffer2.toString());
            }
        }
    }
    /**
     *
     * @param bytes 字节数组
     * @return HuffmanCodeNode
     */
    private List<HuffmanCodeNode> getNodes(byte[] bytes) {
        List<HuffmanCodeNode> nodes = new ArrayList<HuffmanCodeNode>();
        Map<Byte,Integer> counts = new HashMap<Byte, Integer>();
        // 存储并统计byte出现的次数
        for (byte b :bytes) {
            Integer count = counts.get(b);
            if (count == null){
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new HuffmanCodeNode(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }
    /**
     * 通过 list 创建哈夫曼树
     * @param nodes 待构建哈夫曼树的 list
     */
    public HuffmanCodeNode createHuffmanTree(List<HuffmanCodeNode> nodes) {
        while (nodes.size() > 1) {
            // 从小到大
            Collections.sort(nodes);
            // 取出第一二小的数 然后相加形成新的二叉树
            HuffmanCodeNode leftNode = nodes.get(0);
            HuffmanCodeNode rightNode = nodes.get(1);
            HuffmanCodeNode parent = new HuffmanCodeNode(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
    /**
     * 前序遍历
     */
    private void  preOrder(HuffmanCodeNode root) {
        if (root != null) {
            root.preOrder();
        }else{
            System.out.println("哈夫曼树未空");
        }
    }
}
class HuffmanCodeNode implements Comparable<HuffmanCodeNode> {
    /**
     * 数据
     */
    Byte data;
    /**
     * 权值, 表示字符出现的次数
     */
    int weight;
    HuffmanCodeNode left;
    HuffmanCodeNode right;
    public HuffmanCodeNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right !=null ){
            this.right.preOrder();
        }
    }
    @Override
    public int compareTo(HuffmanCodeNode o) {
        // 从小到大
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "HuffmanCodeNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
}