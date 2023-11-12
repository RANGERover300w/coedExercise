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
     * @return int整型ArrayList<ArrayList<>>
     */
     //使用队列去做，将节点存入队列中，然后在依次取出，取出时查看是否有左右节点如果有就放入队列中，知道队列中没有节点。
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        //新建一个返回的二维数组
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        //判断根节点是不是为空，如果是空的话直接返回。
        if(root == null){
            return res;
        }
        //新建一个队列，用于存取节点。
        Queue<TreeNode> q = new ArrayDeque();
        //将根节点放入队列中。
        q.add(root);
        //循环只要队列中有节点就循环。
        while(!q.isEmpty()){
            //新建一个数组返回行数据。
            ArrayList<Integer> row = new ArrayList();
            //取出队列中的节点。
            int n = q.size();
            //此时队列中都是同一行的节点，处理这些节点，要做两件事1.将值村井数组2.将子节点放入队列，这样下次取节点的时候就都为下一层的节点了。
            for(int i = 0;i < n; i++){
            TreeNode cur = q.poll();
            //将节点中的数放入数组中
            row.add(cur.val);
            //左子树不为空，首先放左子树的节点
            if(cur.left != null){
                q.add(cur.left);
            }
            if(cur.right != null){
                q.add(cur.right);
            }
            }
            //将一维数组存进二维数组中。
            res.add(row);
        }
        return res;
    }
}