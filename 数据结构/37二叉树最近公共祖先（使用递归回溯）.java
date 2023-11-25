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
     * @param o1 int整型 
     * @param o2 int整型 
     * @return int整型
     */
     //此题使用的是回溯的方法，先记录下来路径，如果没找到就回溯（删除节点）
    public boolean flag = false;
    public void dfs(ArrayList<Integer> path ,int o,TreeNode root){
        if(flag||root == null){
            return;
        }
        path.add(root.val);
        if(root.val == o){
            flag = true;
            return;
        }
        dfs(path,o,root.left);
        dfs(path,o,root.right);
        if(flag){
            return;
        }
        path.remove(path.size()-1);
    }
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        int res = 0;
        ArrayList<Integer> path1 = new ArrayList();
        dfs(path1,o1,root);
        flag =false;
        ArrayList<Integer> path2 = new ArrayList();
        dfs(path2,o2,root);
        for(int i = 0 ;i < path1.size()&& i<path2.size();i++){
            int x = path1.get(i);
            int y = path2.get(i);
            if(x == y){
                res = path1.get(i);
            }
        }
         return res;
    }
}