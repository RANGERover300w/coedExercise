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
     * @param head1 ListNode类 
     * @param head2 ListNode类 
     * @return ListNode类
     */
     //反转链表
     public ListNode Reverse(ListNode head){
        if(head == null){
            return null;
        }
        ListNode temp , pre = null, cur = head;
        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
     }
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
           ListNode r1 = Reverse(head1);
           ListNode r2 = Reverse(head2);
           ListNode res = new ListNode(-1);
           ListNode head = res;
           int car = 0;
           while(r1 != null || r2 != null || car !=0){
            int v1 = r1 ==  null ? 0 : r1.val;//三元运算符
            int v2 = r2 == null ? 0 : r2.val;
            int temp = (v1 + v2 + car) % 10;
            car = (v1 + v2 +car)/10;
            res.next = new ListNode(temp); //新建节点
            res = res.next;//新节点向后移
            if(r1 != null){
                r1 = r1.next;
            }
            if(r2 != null){
                r2 = r2.next;
            }
           }
        return Reverse(head.next) ;
    }
}