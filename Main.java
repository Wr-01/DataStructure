package dataStructure.stack;

import java.util.List;
import java.util.Stack;

/**
 * @Author: 19261
 * @Date: 2021/10/9 17:25
 */
public class Main {
    public static void main(String[] args) {
        MyStackL myStackL=new MyStackL();
        myStackL.push(1);
        myStackL.push(2);
        myStackL.push(3);
        System.out.println(myStackL);
        System.out.println(myStackL.pop());
        System.out.println(myStackL);
        System.out.println(myStackL.peek());
        myStackL.pop();
        myStackL.pop();
        System.out.println(myStackL.empty());
    }

    public static void main2(String[] args) {
        MyStackA myStackA=new MyStackA();
        myStackA.push(1);
        myStackA.push(2);
        myStackA.push(3);
        System.out.println(myStackA);
        System.out.println(myStackA.pop());
        System.out.println(myStackA);
        System.out.println(myStackA.peek());
        System.out.println(myStackA.empty());
    }
    public static void main1(String[] args) {
        //使用多态的形式创建栈，方便之后的修改；
        //List<Integer> stack1=new Stack<>();
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        System.out.println(stack.peek());
        Integer ret1=stack.pop();
        System.out.println(ret1);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
        System.out.println(stack);
        Integer ret=stack.peek();
        System.out.println(ret);
        System.out.println(stack.empty());
    }
}
