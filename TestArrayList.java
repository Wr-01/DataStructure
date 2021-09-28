package dataStructure;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: 19261
 * @Date: 2021/9/28 11:35
 */
public class TestArrayList {
    public static void main(String[] args) {
        //创建一个顺序表：
        ArrayList<String> arrayList = new ArrayList<>();

        //增加add元素Element
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("A");
        System.out.println(arrayList);
        arrayList.add(1,"N");
        System.out.println(arrayList);

        //删除操作
        //删除顺序表中位置下标为index 的 元素，并返回该元素
        String atr=arrayList.remove(1);
        System.out.println(atr);
        System.out.println(arrayList);
        //删除顺序表中第一个出现的该元素
        arrayList.remove("B");

        //修改操作
        arrayList.set(1, "W");
        System.out.println(arrayList);
        //获取操作
        String s=arrayList.get(0);
        System.out.println(s);

        //遍历顺序表，判断顺序表中是否与参数相等的元素
        boolean c=arrayList.contains("W");
        boolean d=arrayList.contains("A");
        System.out.println(c);
        System.out.println(d);

        //查找元素位置，找到返回下标，反之返回-1；
        //从前往后遍历查找
        int index = arrayList.indexOf("W");
        System.out.println(index);
        //从后往前遍历查找第一个出现该元素的位置：
        int i=arrayList.lastIndexOf("A");
        System.out.println(arrayList);
        System.out.println(i);

        //获取顺序表元数个数：
        int n=arrayList.size();
        System.out.println(n);

        //判断顺序表是否为空：
        boolean e=arrayList.isEmpty();
        System.out.println(e);

        //遍历顺序表：
        //(1)循环遍历的方法：
        for (int j = 0; j < arrayList.size(); j++) {
            System.out.printf(arrayList.get(j)+" ");
        }

        System.out.println();

        //(2)利用迭代器Iterator遍历顺序表
        Iterator<String> it=arrayList.iterator();
        while(it.hasNext()){
            System.out.printf(it.next()+" ");
        }
        System.out.println();

        //(3)通过for-each 遍历整个顺序表
        for (String S:arrayList) {
            System.out.println(S);
        }

//        //清空顺序表
//        arrayList.clear();
//        System.out.println(arrayList);
    }

}
