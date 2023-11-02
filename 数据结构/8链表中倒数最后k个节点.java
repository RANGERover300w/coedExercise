import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param pHead ListNode类 
     * @param k int整型 
     * @return ListNode类
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        if(pHead == null){
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        for(int i = 0;i < k;i++){
            if(fast == null)
            {
                return null;
            }
            fast =fast.next; //快指针向前移动k，
        }
        while(fast != null){
            //如果fast节点是null，代表着slow节点就是倒数第K个节点
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}