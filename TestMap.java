package dataStructure.MapandSet;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: 19261
 * @Date: 2021/11/4 19:52
 */
public class TestMap {
    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        //key是唯一的，后面有相同的key会直接覆盖掉前面的值；
        map.put(1,"张晗");
        map.put(1,"周宛如");
        map.put(2,"张金涛");
        map.put(3,"舒悦天");
        map.put(4,"刘羽");
        System.out.println(map);
        String value = map.get(4);
        value=map.getOrDefault(5,"周宛如");
        System.out.println(value);
        System.out.println(map);
        System.out.println(map.size());
        map.put(5,null);
        System.out.println(map.remove("张金涛"));
        System.out.println(map);
        System.out.println(map.isEmpty());
//        map.clear();
//        System.out.println(map);
//        System.out.println(map.isEmpty());
        System.out.println(map.containsKey(6));
        System.out.println(map.containsKey(1));
        System.out.println(map.containsValue("周宛如"));
        //遍历map
        for (int key : map.keySet()) {
            System.out.println(key);
        }
        for (String v : map.values()) {
            System.out.println(v);
        }
        for(Map.Entry<Integer,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+","+entry.getValue());
            entry.setValue("zzz");
        }
        System.out.println(map);

        Map<Integer,Integer> m=new TreeMap<>();
        m.put(1, 2);
        m.put(3, 4);
        System.out.println(m);
        m.remove(1, 2);
        m.remove(1);
        m.put(5, null);
//        m.put(null, null);key不能为空；否则触发空指针异常；
        System.out.println(m);
    }
}
