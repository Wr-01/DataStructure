package dataStructure;

import java.util.Arrays;

/**
 * @Author: 19261
 * @Date: 2021/9/29 17:16
 */
public class MyArrayList {
    private String[] data;
    private int size;
    private int capacity=100;

    //构造方法：
    public MyArrayList(){
        data =new String[capacity];
    }
    //扩容操作:
    public void realloc(){
        capacity=capacity*2;
        String[] dataNew=new String[capacity];
        for(int i=0;i<size;i++){
            dataNew[i]=data[i];
        }
        data=dataNew;
    }

    //增加操作：
    public boolean add(String e){
        if (size>=capacity){
            realloc();
        }
        data[size]=e;
        size++;
        return true;
    }
    public void add(int index,String e){
        if (index==size){
            data[size]=e;
            size++;
            return;
        }
        if (index<0||index>size){
            return;
        }
        for(int i=size-1;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }

    //删除操作：
    public String remove(int index){
        if (index<0||index>size-1){
            return null;
        }
        for(int i=index;i<size-1;i++){
            data[i] = data[i + 1];
        }
        size--;
        return data[index];
    }
    public boolean remove(String e){
        int i=0;
        for (;i<size;i++){
            if(e.equals(data[i])){
                break;
            }
        }
        if(i>=size){
            return false;
        }
        for(int j=i;j<size-1;j++){
            data[j] = data[j + 1];
        }
        size--;
        return true;
    }

    //get操作：
    public String get(int index){
        if(index<0||index>size-1){
            return null;
        }
        return data[index];
    }
    //set操作：
    public void set(int index,String e){
        if(index<0||index>size-1){
            return;
        }
        data[index]=e;
    }

    //包含操作：
    public boolean contains(String e){
        for (int i=0; i<size;i++){
            if(e.equals(data[i])){
                return true;
            }
        }
        return false;
    }

    //查找操作
    public int indexOf(String e){
        int i=0;
        for (;i<size;i++){
            if(e.equals(data[i])){
                return i;
            }
        }
        return -1;
    }
    public int lastIndexOf(String e){
        int i=size-1;
        for(;i>=0;i--){
            if(e.equals(data[i])){
                return i;
            }
        }
        return -1;
    }

    public void clear(){
        size=0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("[");
        for (int i = 0; i < size; i++) {
            stringBuffer.append(data[i]);
            if ((i<size-1)){
                stringBuffer.append(",");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    //add()测试单元：
    public static void testAdd(){
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add(0,"C");
        myArrayList.add(0,"C++");
        myArrayList.add("JAVA");
        System.out.println(myArrayList);
        myArrayList.add(1,"python");
        myArrayList.add(0,"javasScript");
        myArrayList.add(7,"j");
        System.out.println(myArrayList);
    }

    //remove()测试单元：
    public static void testRemove(){
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add("C");
        myArrayList.add("C++");
        myArrayList.add("Java");
        myArrayList.add("Python");
        myArrayList.add("JavaScript");
        System.out.println(myArrayList);
        myArrayList.remove(0);
        System.out.println(myArrayList);
        myArrayList.remove("JavaScript");
        System.out.println(myArrayList);
    }

    //contains()、clear()、get()、set()测试单元：
    public static void test1(){
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add("C");
        myArrayList.add("C++");
        myArrayList.add("Java");
        myArrayList.add("Python");
        myArrayList.add("JavaScript");
        System.out.println(myArrayList);
        boolean b = myArrayList.contains("Java");
        System.out.println(b);
        String str=myArrayList.get(1);
        System.out.println(str);
        myArrayList.set(0,"C#");
        System.out.println(myArrayList);
        myArrayList.clear();
        System.out.println(myArrayList);
    }

    //index()、lastIndex()、isEmpty()测试单元：
    public static void test2(){
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add("C");
        myArrayList.add("C++");
        myArrayList.add("Java");
        myArrayList.add("Python");
        myArrayList.add("JavaScript");
        System.out.println(myArrayList);
        int index1=myArrayList.indexOf("Python");
        System.out.println(index1);
        int index2 = myArrayList.lastIndexOf("JAva");
        System.out.println(index2);
        boolean l=myArrayList.isEmpty();
        System.out.println(l);
    }

    public static void main(String[] args){
        testAdd();
        testRemove();
        test1();
        test2();
    }
}
