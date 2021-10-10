package dataStructure.Queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: 19261
 * @Date: 2021/10/9 17:26
 */
public class Main {
    public static void main(String[] args) {
        MyQueueA myQueueA=new MyQueueA();
        myQueueA.offer("a");
        myQueueA.offer("b");
        myQueueA.offer("c");
        System.out.println(myQueueA);
        System.out.println(myQueueA.poll());
        System.out.println(myQueueA);
        myQueueA.offer("d");
        System.out.println(myQueueA);
        System.out.println(myQueueA.peek());
        System.out.println(myQueueA);
    }

    public static void main2(String[] args) {
        MyQueueL myQueueL=new MyQueueL();
        myQueueL.offer("z");
        myQueueL.offer("x");
        myQueueL.offer("c");
        myQueueL.offer("v");
        System.out.println(myQueueL);
        System.out.println(myQueueL.poll());
        System.out.println(myQueueL);
        System.out.println(myQueueL.peek());
        System.out.println(myQueueL);
    }

    public static void main1(String[] args) {
        Queue<String> queue=new LinkedList<>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.element());
        System.out.println(queue.remove());
        System.out.println(queue);
    }
}
