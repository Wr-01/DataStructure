package dataStructure.Queue;

/**
 * @Author: 19261
 * @Date: 2021/10/9 17:26
 */
public class MyQueueL {
    static class Node{
        private String val;
        private Node next;

        public Node(String val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;

    //入队操作：
    public boolean offer(String e){
        Node newNode = new Node(e);
        if (head == null) {
            head=newNode;
            tail=newNode;
            return true;
        }
        tail.next=newNode;
        tail=tail.next;
        return true;
    }
    //出队操作
    public String poll(){
        if (head == null) {
            return null;
        }
        String ret=head.val;
        head=head.next;
        return ret;
    }
    //访问队头元素：
    public String peek(){
        if (head == null) {
            return null;
        }
        return head.val;
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
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
