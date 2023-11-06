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
        if(head == null || head.next == null){
            return head;
        }
        // write code here
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode cur = res;
        while(cur.next != null &&  cur.next.next != null){
            if(cur.next.val == cur.next.next.val){//只要有两个值相等就会将值保存下来一直往下探测。
                int temp = cur.next.val;
                while(cur.next != null && cur.next.val == temp){//如果下一个节点不为空就比较
                    cur.next = cur.next.next;
                }
            }
            else cur = cur.next;
        }
    return res.next;
    }
}