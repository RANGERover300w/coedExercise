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
     * @param pHead1 ListNode类
     * @param pHead2 ListNode类
     * @return ListNode类
     */
    public ListNode Merge (ListNode pHead1, ListNode pHead2) {
        // write code here
        ListNode res = new ListNode(0);
        ListNode pre = res;
        if (pHead1 == null) {
            return pHead2;
        }
        if (pHead2 == null) {
            return pHead1;
        }
        if (pHead1 == null && pHead2 == null) {
            return null;
        }
        while (pHead1 != null || pHead2 != null) {
            if (pHead1 != null) {
                if (pHead2 == null) {
                    pre.next = pHead1;
                    pHead1 = pHead1.next;
                }else if (pHead1.val <= pHead2.val) {
                    pre.next = pHead1;
                    pHead1 = pHead1.next;

                } else if (pHead1.val > pHead2.val) {
                    pre.next = pHead2;
                    pHead2 = pHead2.next;

                }
                pre = pre.next;
            } else {
                pre.next = pHead2;
                pHead2 = pHead2.next;
                pre = pre.next;
            }
        }
        return res.next;
    }
}