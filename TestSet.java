package dataStructure.MapandSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: 19261
 * @Date: 2021/11/4 20:33
 */
public class TestSet {
    public static void main(String[] args) {
        Set<String> set=new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        System.out.println(set);
        set.remove("c");
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        System.out.println(set.contains("c"));
        set.remove(null);
        System.out.println(set);
        for (String key : set) {
            System.out.print(key);
        }
        System.out.println();
        Iterator<String> iterator= set.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());
        }
        System.out.println();

        Set<Integer> ss=new TreeSet<>();
        ss.add(1);
        ss.add(2);
        ss.add(3);
        System.out.println(ss);
        ss.remove(2);
        System.out.println(ss);
        //ss.add(null);
        System.out.println(ss.size());
        System.out.println(ss.isEmpty());
        System.out.println(ss);
        System.out.println(ss.contains(1));
    }
}
