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
     * @param preOrder int整型一维数组 
     * @param vinOrder int整型一维数组 
     * @return TreeNode类
     */
     //根据前序遍历和中序遍历的特点，找到根节点，中序遍历到根以前就是左子树。
    public TreeNode reConstructBinaryTree (int[] preOrder, int[] vinOrder) {
        // write code here
        int n = preOrder.length;
        int m = vinOrder.length;
        if(n==0 || m==0){
            return null;
        }
        TreeNode root = new TreeNode(preOrder[0]);
        for(int i = 0; i < vinOrder.length;i++){
            if(preOrder[0] == vinOrder[i]){
                root.left = reConstructBinaryTree(Arrays.copyOfRange(preOrder,1,i+1),Arrays.copyOfRange(vinOrder,0,i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(preOrder,i+1,preOrder.length),Arrays.copyOfRange(vinOrder,i+1,vinOrder.length));
                break;
            }
        }
        return root;
    }
}