package dataStructure.MapandSet;

/**
 * @Author: 19261
 * @Date: 2021/11/6 12:12
 */
class Node{
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }
}
//二叉搜索树：中序遍历是有序递增的，其根节点总是大于左子树节点，小于右子树节点,且不存在相同的值；
public class BinarySearchTree {
    private Node root=null;

    //查找操作
    public Node search(int key) {
        Node cur=root;
        while(cur!=null){
            if(cur.val==key){
                return cur;
            }else if(cur.val>key){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return null;
    }

    //插入操作
    public boolean insert(int key){
        if (root == null) {
            root=new Node(key);
            return true;
        }
        Node cur=root;
        Node parent=null;
        while (cur != null) {
            if (cur.val > key) {
                parent=cur;
                cur=cur.left;
            }else if(cur.val<key){
                parent=cur;
                cur=cur.right;
            }else{
                return false;
            }
        }
        Node newNode = new Node(key);
        if (key > parent.val) {
            parent.right=newNode;
        }else{
            parent.left=newNode;
        }
        return true;
    }

    //删除操作
    public boolean remove(int key) {
        //先判断要删除节点的位置
        Node cur=root;
        Node parent=null;
        while (cur != null) {
            if (key < cur.val) {
                parent=cur;
                cur=cur.left;
            } else if (key > cur.val) {
                parent=cur;
                cur=cur.right;
            }else{
                //找到该节点，进行删除操作
                removeNode(parent,cur);
                return true;
            }
        }
        return false;
    }

    private void removeNode(Node parent, Node toDelete) {
        if(toDelete.left==null){
            if(toDelete==root){
                root=toDelete.right;
            }else if(toDelete==parent.left){
                parent.left=toDelete.right;
            }else{
                parent.right=toDelete.right;
            }
        }else if(toDelete.right==null){
            if (toDelete == root) {
                root=toDelete.left;
            } else if (parent.left == toDelete) {
                parent.left=toDelete.left;
            }else{
                parent.right=toDelete.left;
            }
        }else{
            Node goat=toDelete.right;
            Node goatParent=null;
            while(goat.left!=null){
                goatParent=goat;
                goat=goat.left;
            }
            //修改操作：将替罪羊的值赋给toDelete
            toDelete.val=goat.val;
            if (goat == goatParent.left) {
                goatParent.left=goat.right;
            }else{
                goatParent.right=goat.right;
            }
        }
    }
}
