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
     * @return bool布尔型
     */
     //解题思路：首先判断当前节点是不是空，空就返回true，接着按照中序递归，先遍历左子树，如果小于前一个节点，就代表出错，接着遍历右侧。
     int pre = Integer.MIN_VALUE;
    public boolean isValidBST (TreeNode root) {
        // write code here
        if(root == null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if(root.val < pre){
            return false;
        }
        pre = root.val; //pre 就是上一个遍历的节点。
        return isValidBST(root.right);
    }
}