package dataStructure.List;

/**
 * @Author: 19261
 * @Date: 2021/10/3 10:44
 */
public class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "["+val+"]";
    }
}
