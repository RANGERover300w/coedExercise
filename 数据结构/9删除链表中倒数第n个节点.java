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
     * @param n int整型 
     * @return ListNode类
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode res = head;
        int count = 0;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        while(pre != null){//计数总共有多少个节点
            pre = pre.next;
            count++;
        }
        if(count == n){//如果删除的是头节点，直接返回下一个节点
            return head.next;
        }
        while(fast.next != null){//指针后移找到要删除的节点 slow.next;
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;//删除节点
        return res;
    }
}