package com.xiaou.structure;

/**
 * 单向链表
 * @author xiaou
 */
public class OneLinkedList<T> {
    private OneLinkedNode<T> header;

    /**
     * 追加项
     * @param item 追加项
     */
    public void add(T item) {
        OneLinkedNode<T> temp = header;
        if(temp == null) {
            OneLinkedNode<T> node = new OneLinkedNode<T>();
            node.value = item;
            header = node;
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        OneLinkedNode<T> node = new OneLinkedNode<T>();
        node.value = item;
        temp.next = node;
    }

    /**
     * 指定索引插入数据
     * @param item 插入项
     * @param index 索引 从 0 开始
     */
    public void insert(T item, int index) {
        // 对输入的下标进行合理性判断
        if(index < 0 || index > size()) {
            throw new RuntimeException("指定下标超过当前链表的大小");
        }
        // 如果下一项
        if(index == size()) {
            add(item);
            return;
        }
        // 如果是第一项
        if(index == 0) {
            unshift(item);
            return;
        }
        OneLinkedNode<T> temp = header;
        while (true) {
            if(index == 1) {
                OneLinkedNode<T> node = new OneLinkedNode<T>();
                node.value = item;
                node.next = temp.next;
                temp.next = node;
                break;
            }
            index --;
            temp = temp.next;
        }


    }

    /**
     * 链表的翻转
     */
    public void reverse() {
        // 判断是否含有 2 个节点及以上
        if(header == null || header.next == null) {
            return;
        }
        OneLinkedNode<T> temp = header;
        OneLinkedNode<T> next = null;
        OneLinkedNode<T> tempHand = null;
        while (temp.next != null) {
            next = temp.next;
            temp.next = tempHand;
            tempHand = temp;
            temp = next;
        }
        temp.next = tempHand;
        header = temp;
    }

    /**
     * 链表的拼接
     */
    public void splice(OneLinkedList<T> oneLinkedList) {
        OneLinkedNode<T> temp = header;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = oneLinkedList.header;
    }
    /**
     * 根据下标删除链表节点
     * @param index 下标 从 0 开始
     */
    public void delete(int index) {
        // 对输入的下标进行合理性判断
        if(index < 0 || index > size()) {
            throw new RuntimeException("指定下标超过当前链表的大小");
        }
        OneLinkedNode<T> temp = header;
        if(index == 0){
            header = header.next;
            return;
        }
        while (temp.next != null) {
            if(index <= 1) {
                break;
            }
            index --;
            temp = temp.next;
        }
        System.out.println(temp.value);
        temp.next = temp.next.next;
    }
    /**
     * 插入首项
     * @param item 插入项
     */
    public void unshift(T item) {
        OneLinkedNode<T> node = new OneLinkedNode<T>();
        node.next = header;
        node.value = item;
        header = node;
    }

    /**
     * 链表的长度
     * @return 长度 int
     */
    public int size() {
        int count = 0;
        OneLinkedNode<T> temp = header;
        while (temp != null) {
            count ++;
            temp = temp.next;
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        OneLinkedNode<T> temp = header;
        while (temp != null) {
            sb.append(temp.value);
            sb.append("\n");
            temp = temp.next;
        }
        return sb.toString();
    }
}

class OneLinkedNode<T> {
    public OneLinkedNode<T> next;
    public T value;
}