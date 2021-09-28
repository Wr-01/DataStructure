package dataStructure;

import java.util.ArrayList;

/**
 * @Author: 19261
 * @Date: 2021/9/28 16:25
 */
public class arrayListPractice {
    public static void main(String[] args) {
        //创建一个顺序表，内容为整数
        ArrayList<Integer> arrayList=new ArrayList<>();
        //添加整数到顺序表中
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        System.out.println(arrayList);
        //给指定位置插入元素
        arrayList.add(0,0);
        System.out.println(arrayList);
        arrayList.add(5,5);
        System.out.println(arrayList);

        //删除下表为0的元素(参数为元素 下标)
        arrayList.remove(0);
        System.out.println(arrayList);
        //删除第一个值为该参数的元素
        arrayList.remove(Integer.valueOf(5));
        System.out.println(arrayList);

        //修改某一位置元素的值：
        arrayList.set(3,0);
        System.out.println(arrayList);
        //获取某一位置元素的值：
        int num = arrayList.get(0);
        System.out.println(num);

        //从前往后查找元素的位置
        System.out.println(arrayList);
        int c = arrayList.indexOf(2);
        System.out.println(c);
        System.out.println(arrayList);
        //从后往前查找元素的位置
        int v = arrayList.lastIndexOf(4);
        int w = arrayList.lastIndexOf(3);
        System.out.println(v);
        System.out.println(w);
        //判断顺序表是否
        System.out.println(arrayList);
        boolean l = arrayList.contains(5);
        boolean k = arrayList.contains(2);
        System.out.println(l);
        System.out.println(k);
        //判断顺序表是否为空
        boolean e=arrayList.isEmpty();
        System.out.println(e);

        //获取当前顺序表的元素个数
        System.out.println(arrayList);
        int nn=arrayList.size();
        System.out.println(nn);

        //清空顺序表
        arrayList.clear();
        System.out.println(arrayList);
    }
}
