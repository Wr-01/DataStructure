package dataStructure.List.LinkList;

import aaTest.LeetCode.ListNode;

/**
 * @Author: 19261
 * @Date: 2021/10/7 15:28
 */

class Node {
    public int val;
    public Node prev=null;
    public Node next=null;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "[" + val +"]";
    }
}

//双向链表的实现
public class MyLinkList {
    private Node head;
    private Node tail;
    private int length;

    public MyLinkList() {
        head=null;
        tail=null;
    }

    //增加操作
    //双向链表头插法：
    public void addFirst(int val){
        Node newNode=new Node(val);
        //要插入的双向链表为空时
        if (head==null){
            head=newNode;
            tail=newNode;
        }else{
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }
        length++;
    }
    //尾插法：
    public void addLast(int val){
        Node newNode = new Node(val);
        if(tail==null){
            head=newNode;
            tail=newNode;
        }else{
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }
        length++;
    }
    //在任一个指定位置，插入新节点
    public void add(int index,int val){
        if (index<1||index>length+1){
            return;
        }
        if (index==1){
            addFirst(val);
            return;
        }
        if (index==length+1){
            addLast(val);
            return;
        }
        Node cur=getNode(index);
        Node newNode = new Node(val);
        Node prevNode=cur.prev;
        //先处理前面的链接
        prevNode.next=newNode;
        newNode.prev=prevNode;
        //在处理和当前节点的链接
        newNode.next=cur;
        cur.prev=newNode;
        length++;
    }

    //删除操作
    //头删法：
    public void removeFirst() {
        if (head == null) {
            return;
        }
        head=head.next;
        length--;
    }
    //尾删法：
    public void removeLast() {
        if (head == null) {
            return;
        }
        tail.prev.next=tail.next;
        tail=tail.prev;
        length--;
    }
    //删除任意位置的一个节点
    public void removeByIndex(int index) {
        if (head == null) {
            return;
        }
        if (index<1||index>length){
            return;
        }
        if (index==1){
            removeFirst();
            return;
        }
        if (index==length){
            removeLast();
            return;
        }
        Node prevNode=getNode(index-1);
        Node nextNode=getNode(index+1);
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
        length--;
    }
    //删除一个值为val的节点
    public void removeByVal(int val) {
        if (head == null) {
            return;
        }
        boolean b=contains(val);
        if(b){
            int index=indexOf(val);
            removeByIndex(index);
        }else{
            System.out.println("该链表没有该元素，删除失败！");
        }
    }

    //获取链表长度
    public int getLength() {
        return this.length;
    }

    //获取某一位置的节点
    public Node getNode(int index) {
        if (index<0||index>length){
            return null;
        }
        Node cur=head;
        for(int i=1;i<index;i++){
            cur=cur.next;
        }
        return cur;
    }

    //修改链表某一位置的节点的值
    public void setNode(int index, int val) {
        if (head == null) {
            return;
        }
        if (index < 1 || index > length) {
            return;
        }
        Node curNode = getNode(index);
        curNode.val=val;
    }

    //查找值为e的节点在链表中的第一个位置
    public int indexOf(int val){
        if (head == null) {
            return -1;
        }
        int index=0;
        for (Node cur = head; cur != null; cur = cur.next) {
            index++;
            if(cur.val==val){
                break;
            }
        }
        return index;
    }

    //查找值为e的节点在链表中的倒数第一的位置
    public int lastIndexOf(int val) {
        if (head == null) {
            return -1;
        }
        int index=0;
        for (Node cur = tail; cur != null; cur = cur.prev) {
            if(cur.val==val){
                break;
            }
            index++;
        }
        return getLength()-index;
    }

    //打印链表
    @Override
    public String toString() {
        StringBuilder list=new StringBuilder();
        list.append("[");
        Node cur=head;
        while(cur!=null){
            list.append(cur.val);
            if (cur.next!=null){
                list.append("->");
            }
            cur=cur.next;
        }
        list.append("]");
        return list.toString();
    }

    public boolean contains(int val){
        Node cur=head;
        while (cur != null) {
            if (cur.val==val){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    public boolean isEmpty(){
        return head == null && tail == null;
    }

    public void clear(){
        head=null;
        tail=null;
    }
}
