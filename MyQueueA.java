package dataStructure.Queue;

/**
 * @Author: 19261
 * @Date: 2021/10/9 20:42
 */
//环形队列-数组实现：
public class MyQueueA {
    private String[] data = new String[3];
    private int head=0;
    private int tail=0;
    private int size=0;

    //入队
    public boolean offer(String e) {
        if (size == data.length) {
            //需要扩容；
            return false;
        }
        data[tail]=e;
        if (tail==data.length-1){
            tail=0;
        }else{
            tail++;
        }
        //tail=tail% data.length; 此处的效果同样是tail走到数组最后一个元素位置时，令其返回数组第一个元素位置；
        size++;
        return true;
    }
    //出栈
    public String poll() {
        if (size==0) {
            return null;
        }
        String ret = data[head];
        head++;
        size--;
        return ret;
    }

    //访问队头元素
    public String peek() {
        if (size ==0) {
            return null;
        }
        return data[head];
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer=new StringBuilder();
        stringBuffer.append("[");
        if (head<tail&&tail<=data.length-1){
            for (int i = head; i<tail; i++) {
                stringBuffer.append(data[i]);
                if (i<tail-1){
                    stringBuffer.append("->");
                }
            }
        }
        if(size!=0&&head>=tail){
            for (int i = head; i< data.length; i++) {
                stringBuffer.append(data[i]);
                if (i< data.length-1){
                    stringBuffer.append("->");
                }
            }
            for (int j = 0; j < tail; j++) {
                stringBuffer.append("->");
                stringBuffer.append(data[j]);
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
