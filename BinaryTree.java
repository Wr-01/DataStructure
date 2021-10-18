package aaTest.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: 19261
 * @Date: 2021/10/13 15:03
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTree {
    //二叉树的先序遍历，返回一个线性表（顺序表）
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if (root==null){
            return result;
        }
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }
    //二叉树的中序遍历，返回一个线性表（顺序表）
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if (root==null){
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }
    //二叉树的后序遍历，并返回一个顺序表
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if (root==null){
            return result;
        }
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }
    //判断两个二叉树是否相等
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean result=false;
        if (p==null&&q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    //判断一个二叉树tree是否包含另一个二叉树subRoot(subRoot是否是tree的子树)
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root==null){
            return false;
        }
        return isSameTree(root,subRoot)||isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }
    //给定一个二叉树，找出其最大深度。
    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=getHeight(root.left);
        int r=getHeight(root.right);
        return 1+((l>r)?l:r);
    }
    //判断一个二叉树是否是一个平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        int l=getHeight(root.left);
        int r=getHeight(root.right);
        if (l - r > 1 || l - r < -1) {
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    //给定一个二叉树，检查它是否是镜像对称的。
    //先判断一个树是否是镜像关系
    public boolean isMirror(TreeNode s,TreeNode t){
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val!=t.val){
            return false;
        }
        return isMirror(s.left,t.right)&&isMirror(s.right,t.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isMirror(root.left,root.right);
    }
    //二叉树层序遍历
    public static void levelOrderTraversal(TreeNode root){
         if (root==null){
             return;
         }
        Queue<TreeNode> queue=new LinkedList<>();
         queue.offer(root);
        while (true) {
            TreeNode cur=queue.poll();
            if (cur == null) {
                break;
            }
            System.out.print(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }
    public static TreeNode createTree() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        d.left = g;
        e.left = h;
        e.right = i;
        return a;
    }
    //判断二叉树是否为完全二叉树
    public static boolean isCompleteTree(TreeNode root){
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        boolean level1=true;
        while (true) {
            TreeNode cur=queue.poll();
            if (cur==null){
                break;
            }
            if(level1){
                if (cur.left != null && cur.right != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if (cur.left != null && cur.right == null) {
                    level1=false;
                } else if (cur.left == null && cur.right != null) {
                    return false;
                }
            }else{
                if (cur.left != null && cur.right != null) {
                    return false;
                }
            }
        }
        return true;
    }
    public static TreeNode buildTree() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        d.right=f;
        return a;
    }

    public static void main(String[] args) {
//        TreeNode root=createTree();
//        levelOrderTraversal(root);
        TreeNode root=buildTree();
        boolean ret=isCompleteTree(root);
        System.out.println(ret);
    }
}
