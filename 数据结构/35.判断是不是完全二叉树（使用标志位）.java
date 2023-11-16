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
     //做题思路是  层序遍历，将每一层放入队列中，设立一个标志为，如果为空就设为true
     //如果同层再遇到就返回false；
    public boolean isCompleteTree (TreeNode root) {
        // write code here
        if(root == null){
            return true;
        }
         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
         TreeNode cur;
         boolean notComplete = false;
         while(!queue.isEmpty()){//取出队列中的值，
            cur = queue.poll();
            if(cur == null ){
                notComplete = true;
                continue;
            }
            if(notComplete){
                return false;
            }
            queue.offer(cur.left);
            queue.offer(cur.right);
         }
         return true;
    }
}