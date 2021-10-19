package dataStructure.tree;

import java.util.Arrays;

/**
 * @Author: 19261
 * @Date: 2021/10/18 11:24
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class TreeInterview2 {
    //给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    //最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
    //最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
    public static TreeNode lca=null;
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        findNode(root,p,q);
        return lca;
    }
    public boolean findNode(TreeNode root,TreeNode p,TreeNode q){
        if (root == null) {
            return false;
        }
        int mid= (root==p||root==q)?1:0;
        int left=findNode(root.left,p,q)?1:0;
        int right=findNode(root.right,p,q)?1:0;
        if((mid+left+right)==2){
            lca=root;
        }
        return (mid+left+right)>0;
    }
    //方法2：
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) {
            return null;
        }
        if (root==p||root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor2(root.left,p,q);
        TreeNode right=lowestCommonAncestor2(root.right,p,q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        }else if(right!=null) {
            return right;
        }
        return null;
    }

    //输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        //先找到中序遍历中第一个节点(相当于链表的头节点）：
        TreeNode leftHead=Convert(pRootOfTree.left);
        //找到第一个节点进行尾插：
        TreeNode leftTail=leftHead;
        while (leftTail != null && leftTail.right != null) {
            leftTail=leftTail.right;
        }
        if (leftTail!=null) {
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        //对于根节点右侧子树,将根节点插入右子树前面；
        TreeNode rightNode=Convert(pRootOfTree.right);
        if (rightNode != null) {
            pRootOfTree.right=rightNode;
            rightNode.left=pRootOfTree;
        }
        return leftHead!=null?leftHead:pRootOfTree;
    }

    //给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
    public static int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index=0;
        return _buildTree(preorder,inorder,0, inorder.length);
    }
    public TreeNode _buildTree(int[] preorder, int[] inorder,int leftIndex,int rightIndex) {
        if (leftIndex>=rightIndex) {
            return null;
        }
        if (index>=preorder.length){
            return null;
        }
        TreeNode root=new TreeNode(preorder[index]);
        int pos=find(leftIndex,rightIndex,inorder,root.val);
        index++;
        root.left=_buildTree(preorder,inorder,leftIndex,pos);
        root.right=_buildTree(preorder,inorder,pos+1,rightIndex);
        return root;
    }
    public int find(int left, int right, int[] inorder,int toFind) {
        for (int i = left; i < right; i++) {
            if (inorder[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    //根据一棵树的中序遍历与后序遍历构造二叉树。
    public static int i=0;
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        i=postorder.length-1;
        return buildTree2(inorder,postorder, 0,inorder.length);
    }
    public TreeNode buildTree2(int[] inorder, int[] postorder, int leftI, int rightI) {
        if (leftI>=rightI){
            return null;
        }
        if (i <0) {
            return null;
        }
        TreeNode root=new TreeNode(postorder[i]);
        int pos=find2(leftI,rightI,inorder,root.val);
        i--;
        root.right=buildTree2(inorder,postorder,pos+1,rightI);
        root.left=buildTree2(inorder,postorder,leftI,pos);

        return root;
    }
    public int find2(int left, int right, int[] inorder,int toFind) {
        for (int i = left; i < right; i++) {
            if (inorder[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    //采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
    StringBuffer str=new StringBuffer();
    public String tree2str(TreeNode root) {
        str=new StringBuffer();
        if (root == null) {
            return str.toString();
        }
        getStr(root);
        return str.toString();
    }

    public void getStr(TreeNode root) {
        str.append(root.val);
        if (root.left==null&&root.right!=null){
            str.append("()");
        }
        if (root.left != null) {
            str.append("(");
            getStr(root.left);
            str.append(")");
        }
        if (root.right != null) {
            str.append("(");
            getStr(root.right);
            str.append(")");
        }
    }
}
