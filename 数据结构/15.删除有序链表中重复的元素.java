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
     * @param head ListNode类 
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode next = head.next;
        while(next != null){
            while(pre.val == next.val){
                pre.next = next.next;
                if(next.next != null)
                next = next.next;
                else
                return head;
            }
            pre = pre.next;
            next = next.next;
        }
        return head;
    }
}