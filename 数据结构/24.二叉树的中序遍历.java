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
     //二叉树的中序遍历
    public void inorder(List<Integer> List ,TreeNode root){
        if(root == null){
            return;
        }
        inorder(List,root.left);
        List.add(root.val);
        inorder(List,root.right);
    }
    public int[] inorderTraversal (TreeNode root) {
        // write code here
        List<Integer> list =  new ArrayList<Integer>();
        inorder(list,root);
        int []res = new int[list.size()];
        for(int i = 0; i < list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}