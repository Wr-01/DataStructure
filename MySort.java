package dataStructure.sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: 19261
 * @Date: 2021/11/1 10:15
 */
//原地排序
public class MySort {
    //插入排序：（特点：当数组长度短的时候、当数组元素大多都有序时，插入排序效率很高）
    //稳定排序：两个相等的数据，如果经过排序后，排序算法能保证其相对位置不发生变化，则我们称该算法是具备稳定性的排序算法。
    public static void insertSort(int[] array){
        for (int bound = 1; bound < array.length; bound++) {
            // 有序区间: [0, i)
            // 无序区间: [i, array.length)
            int v = array[bound]; // 无序区间的第一个数
            int cur = bound - 1;
            // 不写 array[j] == v 是保证排序的稳定性
            for (; cur >= 0 && array[cur] > v; cur--) {
                array[cur + 1] = array[cur];
            }
            array[cur + 1] = v;
        }
    }

    //希尔排序：（将需要排序的数组根据gap先分成若干，分别进行插入排序；然后不断更新gap的值，使整个数组更加有序，最后进行插入排序）
   public static void shellSort(int[] arr){
        int gap=arr.length/2;
        while(gap>=1){
            _shellSort(arr,gap);
            gap=gap/2;
        }
   }

    public static void _shellSort(int[] arr, int gap) {
        int bound=gap;
        for (; bound < arr.length; bound++) {
            int v=arr[bound];
            int cur=bound-gap;
            for(;cur>=0&&arr[cur]<v;cur-=gap){
                arr[cur+gap]=arr[cur];
            }
            arr[cur+gap]=v;
        }
    }

    //选择排序：（打擂台的方式，每次将最大或最小元素放到最左边）与冒泡排序有点相似
    public static void selectSort(int[] arr) {
        for (int bound=0;bound < arr.length-1; bound++) {
            for (int cur = bound + 1; cur < arr.length ; cur++) {
                if(arr[bound]>arr[cur]){
                    int tmp=arr[bound];
                    arr[bound]=arr[cur];
                    arr[cur]=tmp;
                }
            }
        }
    }

    //冒泡排序(
    public static void bubbleSort(int[] arr) {
//        for(int bound=0;bound<arr.length-1;bound++){
//            for (int cur = 0;cur<arr.length-bound-1;cur++) {
//                if(arr[cur]>arr[cur+1]){
//                    int tmp=arr[cur+1];
//                    arr[cur+1]=arr[cur];
//                    arr[cur]=tmp;
//                }
//            }
//        }
        for (int bound = 0; bound < arr.length; bound++) {
            for (int cur = arr.length - 1; cur > bound; cur--) {
                if(arr[cur]>arr[cur-1]) {
                    int tmp = arr[cur -1];
                    arr[cur -1] = arr[cur];
                    arr[cur] = tmp;
                }
            }
        }
    }

    //堆排序：
    public static void heapSort(int[] arr){
        createHeap(arr);
        for(int heapSize=arr.length-1;heapSize>0;heapSize--){
            swap(arr,0,heapSize);
            shiftDown(arr,heapSize,0);
        }
    }
    //交换方法
    public static void swap(int[] arr,int a,int b){
        int tmp=arr[a];
        arr[a]=arr[b];
        arr[b]=tmp;
    }
    //创建堆
    public static void createHeap(int[] arr){
        for(int i=(arr.length-1-1)/2;i>=0;i--){
            shiftDown(arr,arr.length,i);
        }
    }
    //向下调整(输入整个数组，但是调整的范围只有0~size-1的范围内，从下标为index的位置向下调整)
    public static void shiftDown(int[] arr,int size,int index){
        int parent=index;
        int child=2*index+1;
        while(child<size){
            if(child+1<size&&arr[child]<arr[child+1]){
                child=child+1;
            }
            if(arr[child]>arr[parent]){
                int tmp=arr[parent];
                arr[parent]=arr[child];
                arr[child]=tmp;
            }else{
                break;
            }
            parent=child;
            child=parent*2+1;
        }
    }

    //快速排序：（以排序范围里的最右侧元素作为基准值，向中间遍历，
    // 前面比基准值小的与后面比基准值大的元素做交换，相遇时，当前元素与基准值交换）
    public static void quickSort(int[] arr){
        //使用一个辅助函数限定排序范围，并进行递归处理
        _quickSort(arr,0,arr.length-1);
    }
    public static void _quickSort(int[] arr, int left, int right) {
        if(left>=right){
            return;
        }
        int index=partition(arr,left,right);// 找到隔断位置
        _quickSort(arr,left,index-1);
        _quickSort(arr,index+1,right);
    }
    public static int partition(int[] arr, int left, int right) {
        int v=arr[right];
        int i=left;
        int j=right;
        while (i < j) {
            while(i<j&&arr[i]<=v){
                i++;
            }
            while(i<j&&arr[j]>=v){
                j--;
            }
            swap(arr,i,j);
        }
        swap(arr,i,right);
        return i;
    }

    //快速排序非递归的方法：(借助栈模拟递归过程)类似于先序遍历进栈的操作
    public static void quickSortByLoop(int[] arr){
        Stack<Integer> stack=new Stack<>();
        stack.push(arr.length-1);
        stack.push(0);
        while (!stack.empty()) {
            int left=stack.pop();
            int right=stack.pop();
            if (left >= right) {
                continue;
            }
            int index = partition(arr, left, right);
            stack.push(right);
            stack.push(index + 1);

            stack.push(index-1);
            stack.push(left);
        }
    }

    public static void main(String[] args) {
        int[] arr={7,2,5,9,5,3,4};
        System.out.println(Arrays.toString(arr));
//        insertSort(arr);
//        System.out.println(Arrays.toString(arr));
//        shellSort(arr);
//        System.out.println(Arrays.toString(arr));
//        selectSort(arr);
//        System.out.println(Arrays.toString(arr));
//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
//        heapSort(arr);
//        System.out.println(Arrays.toString(arr));
//        quickSort(arr);
//        System.out.println(Arrays.toString(arr));
        quickSortByLoop(arr);
        System.out.println(Arrays.toString(arr));
    }
}
