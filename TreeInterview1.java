package aaTest.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: 19261
 * @Date: 2021/10/18 9:12
 */
class TreeNode{
    char val;
    aaTest.LeetCode.TreeNode left;
    aaTest.LeetCode.TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}

public class TreeInterview1 {

    //给你一个二叉树，请你返回其按层序遍历得到的节点值。 （即逐层地，从左到右访问所有节点）。
    public static List<List<Integer>> result=new ArrayList<>();
    //    public static List<List<Integer>> levelOrder(TreeNode root) {
//        result=new ArrayList<>();
//        if (root==null){
//            return result;
//        }
//        helper(root,0);
//        return result;
//    }
//    public static void helper(TreeNode root,int level){
//        if (level == result.size()) {
//            result.add(new ArrayList<>());
//        }
//        result.get(level).add(root.val);
//        if (root.left != null) {
//            helper(root.left,level+1);
//        }
//        if(root.right!=null){
//            helper(root.right,level+1);
//        }
//    }

    //编一个程序，读入用户输入的一串先序遍历字符串，根据此字符串建立一个二叉树（以指针方式存储）。
    // 例如如下的先序遍历字符串： ABC##DE#G##F### 其中“#”表示的是空格，空格字符代表空树。
    // 建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果。
    //中序遍历：
    public static void inOrder(TreeNode root){
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    //通过先序遍历的序列构造二叉树：
    public static int index=0;
    public static TreeNode build(String input){
        char ch=input.charAt(index);
        if (ch=='#'){
            return null;
        }
        TreeNode root=new TreeNode(ch);
        index++;
        root.left=build(input);
        index++;
        root.right=build(input);
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            String input= scanner.next();
            index=0;
            TreeNode root=build(input);
            inOrder(root);
            System.out.println();
        }
    }
}
