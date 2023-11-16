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
     * @param pRoot TreeNode类 
     * @return bool布尔型
     */
     //首先写出求深度的方法
    public int deep(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = deep(root.left);
        int right = deep(root.right);
        return (left > right)? left+1 : right+1;
    }
    public boolean IsBalanced_Solution (TreeNode pRoot) {
        // write code here
      if(pRoot == null){
        return true;
      }
      //平衡二叉树里没课子树的高度差都不超过1
      int left = deep(pRoot.left);
      int right = deep(pRoot.right);
      if((left - right) < -1){
        return false;
      }
      if((left - right) > 1 )
      {
        return false;
      }
      //去判断每一层的子树的高度
      return IsBalanced_Solution(pRoot.left)&&IsBalanced_Solution(pRoot.right);
    }
}