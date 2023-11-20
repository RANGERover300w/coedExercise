import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 求二叉树的右视图
     * @param preOrder int整型一维数组 先序遍历
     * @param inOrder int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    //重建二叉树同上上题，另一个函数是深度遍历，使用两个栈，同时存取，一个存放深度，一个存放节点，建立map存放对应深度的节点，因为这种读取方法，首先会读取最右侧的节点。如果在对应深度节点为空的情况下，就存入map
    public int[] solve (int[] preOrder, int[] inOrder) {
        // write code here
        TreeNode root = buildTree(preOrder,inOrder);
        ArrayList<Integer> list = bfs(root);
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
    public TreeNode buildTree(int[] pre , int[]in){
        int n = pre.length;
        int m = in.length;
        if(m == 0 || n == 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for(int i = 0;i < in.length;i++){
            if(pre[0] == in[i]){
                root.left = buildTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right = buildTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                break;
            }
        }
        return root;
    }
    public ArrayList<Integer> bfs(TreeNode root){
        HashMap<Integer,Integer> mp = new HashMap();
        int max_depth = -1;
        Stack<TreeNode> nodes = new Stack();
        Stack<Integer> depth = new Stack();
        nodes.push(root);
        depth.push(0);
        while(!nodes.isEmpty()){
            TreeNode node = nodes.pop();
            int dep = depth.pop();
            if(node != null){
            max_depth = Math.max(max_depth,dep);
            if(mp.get(dep)==null){
                mp.put(dep,node.val);
            }
            nodes.push(node.left);
            nodes.push(node.right);
            depth.push(dep+1);
            depth.push(dep+1);
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0;i <= max_depth;i++)
        {
            res.add(mp.get(i));
        }
        return res;
    }
}