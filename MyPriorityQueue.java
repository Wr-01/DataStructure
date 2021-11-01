package dataStructure.Heap;

import java.util.Arrays;

/**
 * @Author: 19261
 * @Date: 2021/10/31 16:06
 */
//优先级队列：实际上是一个数组表示的二叉树，这样的完全二叉树数组表示称为堆，堆有大小堆之分；
public class MyPriorityQueue {
    private int[] arr;
    private int size;
    private int capacity=3;

    public MyPriorityQueue() {
        arr=new int[capacity];
    }

    //向下调整，为大堆(前提是，调整位置的两个子树已满足大堆)
    public static void shiftDown(int[] arr,int size,int index){
        int parent=index;
        int child = (2 * index) + 1;
        while (index < size) {
            if(child+1<size&&arr[child]>arr[child+1]){
                child=child+1;
            }
            if(arr[parent]<arr[child]){
                int tmp = arr[parent];
                arr[parent]=arr[child];
                arr[child]=tmp;
            }else{
                break;
            }
            parent=child;
            child=2*parent+1;
        }
    }

    //堆的创建（向下调整）
    public static void createHeap(int[] arr){
        //从第一个非叶子节点比较判断，向下调整
        for(int i=(arr.length-1-1)/2;i>=0;i--){
            shiftDown(arr,arr.length-1,i);
        }
    }

    //向上调整（将当前节点和其父节点比较，比父节点大，则交换）
    public static void shiftUp(int[] arr,int size,int index){
        int child=index;
        int parent=(index-1)/2;
        while(parent>0){
            if(arr[parent]<arr[child]){
                int tmp=arr[parent];
                arr[parent]=arr[child];
                arr[child]=tmp;
            }else{
                break;
            }
            child=parent;
            parent=(child-1)/2;
        }
    }

    //扩容操作：
    public int[] reallocate(int[] arr){
        capacity=capacity*2;
        int[] newArr=new int[capacity];
//        newArr= Arrays.copyOf(arr,arr.length);
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        return newArr;
    }

    //入队(给数组末尾插入一个元素，进行向上调整)
    public void offer(int e){
        if (size>=arr.length){
            //扩容；
            arr=reallocate(arr);
        }
        arr[size++]=e;
        size++;
        //向上调整
        shiftUp(arr,size,size-1);
    }
    //使用向上调整创建堆：
    public void createHeap2(int[] arr){
        for(int x:arr){
            offer(x);
        }
    }

    //获取队首元素
    public Integer getPeek(){
        if (size==0){
            return null;
        }
        return arr[0];
    }

    //删除队首（堆头）元素（将堆头元素与末尾元素交换，在进行向下调整）
    public Integer poll(){
        if (size == 0) {
            return null;
        }
        int tmp=arr[0];
        arr[0]=arr[size-1];
        arr[size-1]=tmp;
        size--;
        shiftDown(arr,size,0);
        return tmp;
    }

}
