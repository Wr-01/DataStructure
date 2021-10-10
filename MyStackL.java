package dataStructure.stack;

/**
 * @Author: 19261
 * @Date: 2021/10/9 19:59
 */
class Node{
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
public class MyStackL {
    private Node head;

    //入栈操作
    public void push(int v) {
        Node newNode = new Node(v);
        if (head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    //出栈操作
    public Integer pop() {
        if (head == null) {
            return null;
        }
        int ret=head.val;
        head=head.next;
        return ret;
    }

    //访问栈顶元素
    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }

    //判断是否为空
    public boolean empty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (Node cur = head; cur != null; cur = cur.next) {
            stringBuffer.append(cur.val);
            if (cur.next != null) {
                stringBuffer.append("->");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
