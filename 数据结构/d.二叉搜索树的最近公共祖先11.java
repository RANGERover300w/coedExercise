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
     * @param p int整型 
     * @param q int整型 
     * @return int整型
     */
    public ArrayList<Integer> getPath(TreeNode root ,int target){
        ArrayList<Integer> path = new ArrayList();
        TreeNode node = root;
        //遍历二叉树找到节点存进数组中，遍历两个数组找到相同节点
        while(node.val != target){
            path.add(node.val);
            if(target > node.val){
                node = node.right;
            }else{
                node = node.left;
            }
        }
        path.add(node.val);//把找到的那个值也放入数组中。
        return path;
    }
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        // write code here
        ArrayList<Integer> path1 = getPath(root,p);
        ArrayList<Integer> path2 = getPath(root,q);
        int res = 0;
        for(int i = 0;i<path1.size()&&i<path2.size();i++){
            int x = path1.get(i);
            int y = path2.get(i);
            if(x == y){
                res = path1.get(i);
            }else{
                break;
            }
        }
        return res;
    }
}