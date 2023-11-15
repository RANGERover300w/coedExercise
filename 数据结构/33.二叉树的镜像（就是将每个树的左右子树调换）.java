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
     * @return TreeNode类
     */
   
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if(pRoot == null){
            return null;
        }
        TreeNode left = Mirror(pRoot.left);
        TreeNode right = Mirror(pRoot.right);
        pRoot.right = left;
        pRoot.left = right;
        return pRoot;
    }
}