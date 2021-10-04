package dataStructure.List.deleteInsert;

import dataStructure.List.Node;

/**
 * @Author: 19261
 * @Date: 2021/10/4 10:46
 */
public class MainNode {
    //创建不带dummy node傀儡节点的链表：
    public static Node createList(){
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=null;
        return a;
    }
    //遍历打印整个链表元素：
    public static void printList(Node head){
        if (head==null){
            return;
        }
        for (Node cur=head;cur!=null;cur=cur.next){
            System.out.print(cur.val+" ");
        }
        System.out.println();
    }
    //获取不带傀儡节点的链表元素个数：
    public static int getSize(Node head){
        if (head==null){
            return 0;
        }
        int size=0;
        for (Node cur=head;cur!=null;cur=cur.next){
            size++;
        }
        return size;
    }

    //不带傀儡节点的插入和删除操作实现：
    //头插法：给不带傀儡节点的链表的头部插入一个新节点
    public static Node insertHead(Node head,Node newNode){
        //头插法：将新的节点插入到头结点的位置
        newNode.next=head;
        head=newNode;
        return head;
    }
    //给不带傀儡节点的链表插入一个新的节点
    public static void insert(Node head,Node newNode,int index){
        if (head==null){
            return;
        }
        if (index<1||index>getSize(head)+1){
            return;
        }
        //将新节点插入到链表中：
        if (index>1&&index<=getSize(head)+1){
            Node prev=head;
            for(int i=1;i<index-1;i++){
                prev=prev.next;
            }
            //循环结束，找到要插入位置的前一个节点；
            newNode.next=prev.next;
            prev.next=newNode;
        }
//        //给链表末尾插入一个新的节点：
//        if (index==getSize(head)+1){
//            Node prev=head;
//            while(prev.next!=null){
//                prev=prev.next;
//            }
//            //此时循环结束的prev就是链表最后一个节点
//            newNode.next=prev.next;  //将最后一个节点的next的null赋值给新元素；
//            prev.next=newNode;
//        }
    }

    //测试单元 不带傀儡节点的插入
    public static void test1(){
        Node head=createList();
        printList(head);
        //给链表中插入一个新的节点；
        Node newNode1=new Node(5);
        int index1=1;
        int index2=2;
        int index3=getSize(head);
        //测试在链表头插入
        Node newNode=new Node(8);
        head =insertHead(head,newNode);
        printList(head);
        //测试在链表中插入：
        insert(head,newNode1,index3);
        printList(head);
        //测试在链表尾插入：
        Node newNode2=new Node(6);
        insert(head,newNode2,7);
        printList(head);
        Node newNode3=new Node(0);
        insert(head,newNode3,index2);
        printList(head);
        head = insertHead(head,new Node(7));
        printList(head);
    }

    //删除不带傀儡节点的链表节点
    //头删法：删除链表第一个节点：
    public static Node remove0(Node head) {
        if (head == null) {
            return null;
        }
        head=head.next;
        return head;
    }
    //通过元素位置删除链表中的节点：
    public static void remove1(Node head, int index) {
        if (head==null){
            return;
        }
        if (index<1||index>getSize(head)){
            return;
        }
        Node prev=head;
        for (int i=1;i<index-1;i++){
            prev=prev.next;
        }
        //循环结束，prev是要删除节点的前一个节点
        prev.next=prev.next.next;
    }

    //根据节点值删除链表中的节点：
    public static Node remove3(Node head,int value){
        Node prev = head;
        if (prev.val==value){
            head=prev.next;
            return head;
        }
        for (; prev != null; prev = prev.next) {
            if (prev.next.val==value){
                break;
            }
        }
        prev.next=prev.next.next;
        return head;
    }

    //测试不带傀儡节点的通过位置的删除操作单元:
    public static void test2(){
        Node head=createList();
        printList(head);
        //头删：
        head =remove0(head);
        printList(head);
        //根据 位置 删除链表中的节点:
        remove1(head,2);
        printList(head);
        remove1(head,2);
        printList(head);
    }
    //通过值删除的不带傀儡节点链表节点的操作测试单元：
    public static void test3(){
        Node head=createList();
        printList(head);
        head=remove3(head,3);
        printList(head);
        head=remove3(head,1);
        printList(head);
        head=remove3(head,4);
        printList(head);
    }

    public static void main1(String[] args) {
        test1();
        test2();
        test3();
    }

    //创建带傀儡dummy 节点的链表
    public static Node createListWithDummy(){
        Node dummy=new Node(0);
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        dummy.next=a;
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=null;
        return dummy;
    }
    //遍历打印整个链表元素：
    public static void printListWithDummy(Node head){
        if (head.next==null){
            return;
        }
        for (Node cur=head.next;cur!=null;cur=cur.next){
            System.out.print(cur.val+" ");
        }
        System.out.println();
    }
    //获取带傀儡节点的链表元素个数：
    public static int getSizeWithDummy(Node head){
        if (head.next==null){
            return 0;
        }
        int size=0;
        for (Node cur=head.next;cur!=null;cur=cur.next){
            size++;
        }
        return size;
    }

    //给傀儡节点插入一个新的节点：
    public static void insertNode(Node head,Node newNode,int index){
        if (index<1||index>getSizeWithDummy(head)+1){
            return;
        }
        Node prev=head;
        for (int i=1;i<index;i++){
            prev=prev.next;
        }
        newNode.next=prev.next;
        prev.next=newNode;
    }
    //测试带傀儡节点的链表插入新的节点：
    public static void test4(){
        Node head=createListWithDummy();
        printListWithDummy(head);
        Node newNode1=new Node(0);
        insertNode(head,newNode1,1);
        printListWithDummy(head);
        Node newNode2=new Node(9);
        insertNode(head,newNode2,5);
        printListWithDummy(head);
        Node newNode3=new Node(8);
        insertNode(head,newNode3,7);
        printListWithDummy(head);
    }

    //带傀儡节点的链表删除一个已知位置的节点：
    public static void remove4(Node head,Node toDelete){
        if (head.next==null){
            return;
        }
        Node prev=head;
        while(prev.next!=null && prev.next!=toDelete){
            prev=prev.next;
        }
        if (prev.next == null) {
            System.out.println("该节点不存在在该链表里！");
            return;
        }
        prev.next=prev.next.next;
    }
    //测试删除带傀儡节点的链表的节点：
    public static void test5(){
        Node head=createListWithDummy();
        printListWithDummy(head);
        //删除特定节点
        Node toDelete=head.next.next.next.next;
        remove4(head,toDelete);
        printListWithDummy(head);
    }

    //删除傀儡节点的已知节点的下标位置：
    public static void remove5(Node head,int index){
        if (head.next==null){
            return;
        }
        if (index<1||index>getSizeWithDummy(head)){
            return;
        }
        Node prev=head;
        for (int i=1;i<index;i++){
            prev=prev.next;
        }
        prev.next=prev.next.next;
    }
    //测试带傀儡节点的链表删除某下标的节点：
    public static void test6(){
        Node head=createListWithDummy();
        printListWithDummy(head);
        int index1=1;
        remove5(head,index1);
        printListWithDummy(head);
        int index2=3;
        remove5(head,index2);
        printListWithDummy(head);
    }

    public static void main(String[] args) {
        test4();
        test5();
        test6();
    }
}
