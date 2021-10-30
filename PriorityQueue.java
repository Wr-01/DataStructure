package dataStructure.Heap;

import java.util.Comparator;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: 19261
 * @Date: 2021/10/30 19:52
 */
//class BoyFriend implements Comparable<BoyFriend>{
class BoyFriend{
    public String name;
    public int money;
    public int face;

    public BoyFriend(String name, int money, int face) {
        this.name = name;
        this.money = money;
        this.face = face;
    }

//    @Override
//    public int compareTo(BoyFriend o) {
////        return o.face-this.face;
//        return o.money-this.money;
//    }

    @Override
    public String toString() {
        return "{" + name + ','  + money + ',' + face + '}';
    }
}
class BoyFriendomplarator implements Comparator<BoyFriend>{
    @Override
    public int compare(BoyFriend o1, BoyFriend o2) {
        return o2.face-o1.face;
//        return o2.money-o1.money;
    }
}

public class PriorityQueue {
    public static void main(String[] args){
        Queue<BoyFriend> queue=new java.util.PriorityQueue<>(new BoyFriendomplarator());
        queue.offer(new BoyFriend("张三",99,60));
        queue.offer(new BoyFriend("李四",999,50));
        queue.offer(new BoyFriend("王五",9,100));
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }



//        Queue<Integer> priorityQueue=new java.util.PriorityQueue<>();
//        priorityQueue.offer(1);
//        priorityQueue.offer(0);
//        priorityQueue.offer(4);
//        System.out.println(priorityQueue.peek());
////        priorityQueue.poll();
//        System.out.println(priorityQueue); //输出结果为：0，1，4 按照一定优先级排列；
//        Stack<Integer> stack=new Stack<>();
//        stack.push(0);
//        stack.push(3);
//        stack.push((2));
//        System.out.println(stack);
    }
}
