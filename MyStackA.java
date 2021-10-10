package dataStructure.stack;

import java.util.Arrays;

/**
 * @Author: 19261
 * @Date: 2021/10/9 17:25
 */
//栈的实现
public class MyStackA {
    private Integer[] data=new Integer[100];
    private int size=0;

    //入栈
    public void push(int v){
        data[size]=v;
        size++;
    }
    //出栈
    public Integer pop(){
        if (size==0){
            return null;
        }
        return data[--size];
    }
    //返回栈顶元素
    public Integer peek(){
        if (size==0){
            return null;
        }
        return data[size-1];
    }
    //empty判断栈是否为空
    public boolean empty(){
        return size==0;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("[");
        for (int i = 0; i < size; i++) {
            stringBuffer.append(data[i]);
            if (i<size-1){
                stringBuffer.append("|");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

