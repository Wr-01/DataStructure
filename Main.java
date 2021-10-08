package dataStructure.List.LinkList;

import genericProgram.Person;

/**
 * @Author: 19261
 * @Date: 2021/10/8 10:24
 */
public class Main {
    public static void testAdd() {
        MyLinkList linkList=new MyLinkList();
        linkList.addFirst(1);
        linkList.addFirst(2);
        linkList.addFirst(3);
        System.out.println(linkList);
        linkList.addLast(2);
        linkList.addLast(3);
        System.out.println(linkList);
        linkList.add(1,0);
        System.out.println(linkList);
        linkList.add(5,0);
        System.out.println(linkList);
        linkList.add(6,5);
        System.out.println(linkList);
    }
    public static void test(){
        MyLinkList linkList=new MyLinkList();
        linkList.addFirst(0);
        linkList.addLast(1);
        linkList.addLast(2);
        linkList.addLast(2);
        linkList.addLast(4);
        System.out.println(linkList);
        int index1=linkList.indexOf(2);
        System.out.println(index1);
        int index2=linkList.lastIndexOf(2);
        System.out.println(index2);
        boolean l=linkList.contains(3);
        System.out.println(l);
        boolean b=linkList.contains(0);
        System.out.println(b);
        boolean o=linkList.isEmpty();
        System.out.println(o);
        linkList.clear();
        System.out.println(linkList);
    }

    public static void testRemove(){
        MyLinkList linkList=new MyLinkList();
        linkList.addFirst(0);
        linkList.addLast(1);
        linkList.addLast(2);
        linkList.addLast(3);
        linkList.addLast(4);
        System.out.println(linkList);
        linkList.removeFirst();
        System.out.println(linkList);
        linkList.removeLast();
        System.out.println(linkList);
        linkList.removeByIndex(1);
        System.out.println(linkList);
        linkList.removeByIndex(linkList.getLength());
        System.out.println(linkList);
        linkList.removeByVal(3);
        System.out.println(linkList);
        linkList.removeByVal(4);
        System.out.println(linkList);
        linkList.removeByVal(0);
        System.out.println(linkList);
        linkList.removeByVal(2);
        System.out.println(linkList);
        linkList.removeByVal(1);
        System.out.println(linkList);
    }
    public static void main(String[] args) {
        //testAdd();
        testRemove();
        //test();
    }
}
