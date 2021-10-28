package Practice1028;

import java.util.Stack;

/**
 * @Author: 19261
 * @Date: 2021/10/28 14:54
 */
public class BinaryTree {
    //构造二叉树：
    public static TreeNode createTree(){
        TreeNode a=new TreeNode("A");
        TreeNode b=new TreeNode("B");
        TreeNode c=new TreeNode("C");
        TreeNode d=new TreeNode("D");
        a.left=b;
        a.right=c;
        c.left=d;
        return a;
    }
    public static void main(String[] args){
        TreeNode root=createTree();
//        preOrderTraversal(root);
//        System.out.println();
//        preOrder(root);
//        System.out.println();
//        inOrderTraversal(root);
//        System.out.println();
//        inOrder(root);
//        System.out.println();
        postoOrderTraversal(root);
        System.out.println();
        postOrder(root);

    }
    //先序遍历非递归方法：
    public static void preOrder(TreeNode root){
        if (root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode cur=stack.pop();
            System.out.print(cur.val);
            if(cur.right!=null){
                stack.push(root.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }
    //先序遍历：
    public static void preOrderTraversal(TreeNode root){
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //中序遍历：
    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val);
        inOrderTraversal(root.right);
    }
    //中序遍历非递归方法：
    public static void inOrder(TreeNode root){
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        TreeNode ret=stack.peek();
        while(!stack.empty()){
            while (ret.left != null) {
                stack.push(ret.left);
                ret=ret.left;
            }
            TreeNode cur=stack.pop();
            System.out.print(cur.val);
            if (cur.right!=null){
                stack.push(cur.right);
                if (cur.right.left!=null){
                    ret=cur.right;
                }
            }
        }
    }

    //后序遍历：
    public static void postoOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postoOrderTraversal(root.left);
        postoOrderTraversal(root.right);
        System.out.print(root.val);
    }

    //后序遍历非递归的方法：
    public static void postOrder(TreeNode root) {
        if (root==null){
            return;
        }
        Stack<TreeNode>stack=new Stack<>();
        TreeNode cur = root;
        TreeNode prev=null;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur=cur.left;
            }
            if(stack.empty()){
                break;
            }
            TreeNode tmp=stack.peek();
            if (tmp.right==null||tmp.right==prev){
                System.out.print(tmp.val);
                stack.pop();
                prev=tmp;
            }else{
                cur=tmp.right;
            }
        }
    }
}
