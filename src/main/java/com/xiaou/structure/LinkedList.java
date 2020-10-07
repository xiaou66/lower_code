package com.xiaou.structure;

/**
 * @author xiaou
 */
public class LinkedList {
    private LinkedNode header = null;
    private LinkedNode tail = null;
    public void push(String value) {
        if(header == null && tail == null) {
            LinkedNode linkedNode = new LinkedNode(null, null, value);
            header = linkedNode;
            tail = linkedNode;
            return;
        }
        LinkedNode linkedNode = new LinkedNode(tail, null, value);
        tail.next =linkedNode;
        tail = linkedNode;
    }
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        LinkedNode temp = header;
        while (true) {
            if(temp.next == null){
                sb.append(temp.value);
                break;
            }
            sb.append(temp.value);
            sb.append("\t");
            temp = temp.next;
        }
        return sb.toString();
    }
}
class LinkedNode {
    public LinkedNode prev;
    public LinkedNode next;
    public String value;
    public LinkedNode(LinkedNode prev, LinkedNode next, String value) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }
}