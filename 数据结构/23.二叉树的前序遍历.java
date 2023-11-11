import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 *   public TreeNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param root TreeNode类 
     * @return int整型一维数组
     */

     public void preorder(List<Integer> List,TreeNode root){
        if(root == null){
            return;
        }
        List.add(root.val);
        preorder(List , root.left);
        preorder(List,root.right);
     }
    public int[] preorderTraversal (TreeNode root) {
        // write code here
       ArrayList<Integer> List = new  ArrayList<Integer>();
       preorder(List ,root);
       int []res = new int[List.size()];
       for(int i = 0; i < List.size();i++){
        res[i] = List.get(i);
       }
       return res;
    }
}