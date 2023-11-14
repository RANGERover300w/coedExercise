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
     TreeNode head = null;
     TreeNode pre = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
       if(pRootOfTree == null){
        return null;
       }
       Convert(pRootOfTree.left);
       if(head == null){
        head = pRootOfTree;
        pre = pRootOfTree;
       } else{
        pRootOfTree.left = pre;
        pre.right = pRootOfTree;
        pre = pRootOfTree;
       }
       Convert(pRootOfTree.right);
       return head;
    }
}
