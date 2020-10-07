package com.xiaou.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaou
 */
public class CircleSingleLinked<T> {
    private CircleSingleNode<T> header;

    /**
     * 约瑟夫问题
     * 调用这个方法后环形列表将为空
     * @param m 报数个数
     * @param start 开始位置
     * @return 出链顺序
     */
    public List<T> YSFQuestion(int m, int start) {
        List<T> values = new ArrayList<T>();
        CircleSingleNode<T> cursor = header;
        while (start != 0){
            // 移动浮标到指定位置
            cursor = cursor.getNext();
            start --;
        }
        CircleSingleNode<T> next;
        int currentNumber = m -1;
        while (true) {
            if(cursor == cursor.getNext()){
                // 当出现自己连自己的情况
                values.add(cursor.getValue());
                break;
            }
            currentNumber --;
            if(currentNumber != 0) {
                cursor = cursor.getNext();
                continue;
            }
            values.add(cursor.getNext().getValue());
            next = cursor.getNext().getNext();
            // 断开下一个节点
            cursor.setNext(cursor.getNext().getNext());
            cursor = next;
            currentNumber = m -1;
        }
        return values;
    }
    public void add(T value) {
        if(header == null) {
            // 当添加第一天节点时,设置为头节点,并且让其自连
            header = new CircleSingleNode<T>();
            header.setValue(value);
            header.setNext(header);
            return;
        }
        CircleSingleNode<T> cursor = header;
        while (cursor.getNext() != header) {
            // 当节点下一个不是第一个节点时
            cursor = cursor.getNext();
        }
        // 到达最后节点
        CircleSingleNode<T> circleSingleNode = new CircleSingleNode<T>();
        circleSingleNode.setValue(value);
        cursor.setNext(circleSingleNode);
        circleSingleNode.setNext(header);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        CircleSingleNode<T> cursor = header;
        while (cursor.getNext() != header) {
            // 当节点下一个不是第一个节点时
            sb.append(cursor.getValue());
            sb.append("\n");
            cursor = cursor.getNext();
        }
        sb.append(cursor.getValue());
        sb.append("\n");
        return sb.toString();
    }
}
class CircleSingleNode <T> {
    private CircleSingleNode<T> next;
    private T value;
    public CircleSingleNode<T> getNext() {
        return next;
    }

    public void setNext(CircleSingleNode<T> next) {
        this.next = next;
    }
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}