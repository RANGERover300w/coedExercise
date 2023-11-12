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
     * @return int整型ArrayList<ArrayList<>>
     */
    //使用标志位，利用数组的反转。剩下的原理同层序遍历
    public ArrayList<ArrayList<Integer>> Print (TreeNode pRoot) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if(pRoot == null){
            return res;
        }
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.add(pRoot);
        Boolean flag = false;
        while(!q.isEmpty()){
            ArrayList<Integer> row = new ArrayList();
            int n = q.size();
            for(int i = 0 ; i < n;i++){
                TreeNode cur = q.poll();
                row.add(cur.val);
                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }
            }
            if(flag){
                Collections.reverse(row);
            }
            flag = !flag;   
            res.add(row);         
        }
        return res;
    }
}