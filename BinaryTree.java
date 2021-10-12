package dataStructure.tree;

/**
 * @Author: 19261
 * @Date: 2021/10/12 21:03
 */
class Node{
    String val;
    Node left;
    Node right;

    public Node(String val) {
        this.val = val;
    }

}
public class BinaryTree {
    //创建一个树，写死
    public static Node createTree(){
        Node a=new Node("A");
        Node b=new Node("B");
        Node c=new Node("C");
        Node d=new Node("D");
        Node e=new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        e.left=f;
        c.left=g;
        return a;
    }

    public static void main(String[] args) {
        Node root=createTree();
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        getCount(root);
        System.out.println(count);
        System.out.println(getCountI(root));
    }

    //先序遍历
    public static void preOrder(Node root){
        if (root==null){
            return;
        }
        System.out.print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    //中序遍历
    public static void inOrder(Node root){
        if (root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val);
        inOrder(root.right);
    }
    //后序遍历
    public static void postOrder(Node root){
        if (root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val);
    }
    //计算树的节点个数
    public static int count=0;
    public static void getCount(Node root){
        if (root==null){
            return;
        }
        count++;
        getCount(root.left);
        getCount(root.right);
    }
    //计算树节点个数并返回值
    public static int getCountI(Node root){
        if (root==null){
            return 0;
        }
        return 1+getCountI(root.left)+getCountI(root.right);
    }
}
