package dataStructure.List;

/**
 * @Author: 19261
 * @Date: 2021/10/3 10:47
 */
public class Main {

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
    public static void main(String[] args) {
        Node head= createList();
//        System.out.println(head);
//        System.out.println(head.val);
//        System.out.println(head.next.val);

//        //通过遍历，打印链表的每个元素:
//        for (Node cur=head;cur.next!=null;cur=cur.next){
//            System.out.println(cur.val);
//        }
//        //通过遍历，找到链表的最后一个结点:
//        Node node=head;
//        while(node.next!=null){
//            node=node.next;
//        }
//        System.out.println(node.val);

//        //通过遍历，找到链表的倒数第二个结点:
//        Node cur=head;
//        while(cur!=null && cur.next!=null && cur.next.next!=null ){
//            cur=cur.next;
//        }
//        System.out.println(cur.val);
//        System.out.println(cur);

//        //通过遍历，找到链表的第 n 个结点:
//        int n=4;
//        Node cur=head;
//        for (int i = 1; i < n; i++) {
//            cur=cur.next;
//        }
//        System.out.println(cur);

//        //通过遍历，计算链表中元素的个数:
//        int count=0;
//        for(Node cur=head;cur!=null;cur=cur.next){
//            count++;
//        }
//        System.out.println(count);

//        //通过遍历链表，获取链表倒数第n个节点：size+1-倒数第n个；
//        int n=2;
//        Node cur=head;
//        for(int i=1;i<count+1-n;i++){
//            cur=cur.next;
//        }
//        System.out.println(cur);

//        //通过遍历，找到链表中是否包含某个元素:
//        int num=1;
//        Node cur = head;
//        for (; cur.next != null; cur = cur.next) {
//            if(num==cur.val){
//                break;
//            }
//        }
//        if(cur.next!=null){
//            System.out.println("找到了！");
//        }else{
//            System.out.println("没找到！");
//        }
    }
}
