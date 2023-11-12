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
    public void postorder(List list ,TreeNode root){
        if(root == null){
            return;
        }
        postorder(list,root.left);
        postorder(list,root.right);
        list.add(root.val);
    }
    public int[] postorderTraversal (TreeNode root) {
        // write code here
        List<Integer> list = new ArrayList<Integer>();
        postorder(list,root);
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}