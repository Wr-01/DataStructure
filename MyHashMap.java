package dataStructure.MapandSet;

/**
 * @Author: 19261
 * @Date: 2021/11/7 16:19
 */
class HashNode{
    public int key;
    public int value;
    public HashNode next;

    public HashNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class MyHashMap {
    private HashNode[] hashMap=new HashNode[10];
    private int size=0;
    private static final double LOAD_FACTOR=0.75;

    //插入元素
    public void put(int key, int value) {
        int index=key%hashMap.length;
        //判断表中是否已有key
        for(HashNode cur=hashMap[index];cur!=null;cur=cur.next){
            if (cur.key == key) {
                cur.value=value;
                return;
            }
        }
        HashNode newNode=new HashNode(key,value);
        newNode.next=hashMap[index];
        hashMap[index]=newNode;
        size++;

        if(loadFactor()>LOAD_FACTOR){
            reSize();
        }
    }

    //扩容操作
    private void reSize(){
        HashNode[] newHash = new HashNode[hashMap.length * 2];
        for (int i = 0; i < hashMap.length; i++) {
            HashNode next=null;
            for (HashNode cur = hashMap[i]; cur != null; cur = next) {
                next=cur.next;
                int newIndex=cur.key/newHash.length;
                cur.next = newHash[newIndex];
                newHash[newIndex]=cur;
            }
        }
        hashMap=newHash;
    }

    //计算负载因子=已填入表的元素个数/哈希表的长度
    private double loadFactor(){
        return (double)size/hashMap.length;
    }

    //通过key找value
    public Integer get(int key) {
        int index=key%hashMap.length;
        //判断表中是否已有key
        for(HashNode cur=hashMap[index];cur!=null;cur=cur.next){
            if (cur.key == key) {
                return cur.value;
            }
        }
        return null;
    }
}
