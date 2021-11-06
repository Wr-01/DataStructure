package dataStructure.MapandSet.leetCode;

import java.util.*;

/**
 * @Author: 19261
 * @Date: 2021/11/5 10:11
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class Solution1105 {
    //复杂链表的复制：
    public RandomListNode Clone(RandomListNode pHead) {
        Map<RandomListNode,RandomListNode> map=new HashMap<>();
        for(RandomListNode cur=pHead;cur!=null;cur=cur.next){
            map.put(cur,new RandomListNode(cur.label));
        }
        for (RandomListNode old = pHead; old != null; old = old.next) {
            RandomListNode newNode=map.get(old);
            RandomListNode newNodeNext=map.get(old.next);
            newNode.next=newNodeNext;
            RandomListNode newNodeRandom=map.get(old.random);
            newNode.random=newNodeRandom;
        }
        return map.get(pHead);
    }

    //找出数组中只出现一次的数字
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])==null){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return 0;
    }

    //前一个字符串的字符，在后一个字符串中出现的次数
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set=new HashSet<>();
        for(int i=0;i<jewels.length();i++){
            set.add(jewels.charAt(i));
        }
        int count=0;
        for (int j = 0; j < stones.length(); j++) {
            if(set.contains(stones.charAt(j))){
                count++;
            }
        }
        return count;
    }

    //判断键盘坏的键，要求输出为不重复的大写字母
    public static void main(String[] aegs){
//        String[] word={"i","i","word","c","word"};
//        System.out.println(topKFrequent(word,2));
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String expect=sc.next();
            String actual=sc.next();
            expect=expect.toUpperCase();
            actual=actual.toUpperCase();
            Set<Character> s1=new HashSet<>();
            for(int i=0;i<actual.length();i++){
                s1.add(actual.charAt(i));
            }
            Set<Character> s2=new HashSet<>();
            for(int j=0;j<expect.length();j++){
                char c=expect.charAt(j);
                if(s1.contains(c)){
                    continue;
                }
                if(s2.contains(c)){
                    continue;
                }
                System.out.print(c);
                s2.add(c);
            }
            System.out.println();
        }
    }

    //给一非空的单词列表，返回前 k 个出现次数最多的单词。
    //返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map=new HashMap<>();
        for(String s:words){
            int value=map.getOrDefault(s,0);
            map.put(s,value+1);
        }
        List<String> wordList=new ArrayList<>(new HashSet<>(map.keySet()));
        Collections.sort(wordList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int c1=map.get(o1);
                int c2=map.get(o2);
                if (c1 == c2) {
                    return o1.compareTo(o2);
                }
                return c2-c1;
            }
        });
        return wordList.subList(0,k);
    }

}
