import java.util.*;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public ArrayList convert(TreeNode root, ArrayList list) {
        if (root == null) {
            return list;
        }
        convert(root.left, list);
        list.add(root);//将节点放入数组中
        convert(root.right, list);
        return list;
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList();
        list = convert(pRootOfTree ,list);
        int i = 0;
        if(list.size() > 2){
        for( i = 0; i < list.size()-1 ; i++){ //遍历数组，将每个节点修改
            TreeNode cur = list.get(i);
            TreeNode next = list.get(i+1);
            if(i == 0){
                cur.right = next;
            }else{
                TreeNode pre = list.get(i-1);
                cur.left = pre;
                cur.right = next;
            }
        }
        TreeNode cur = list.get(i);
        TreeNode pre = list.get(i-1);
        pre.right = cur;
        cur.left = pre;
        }
        return list.get(0);
    }
}
