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
     * @param head ListNode类 the head node
     * @return ListNode类
     */
     //使用双链表解法，对单链表进行排序。
     //合并两个单链表
     public ListNode merge(ListNode head1,ListNode head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
             cur.next = head1;
             head1 = head1.next;
            }else{
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if(head1 != null)  //如果有剩余直接加到链表的末尾
           cur.next = head1;
        else
        cur.next = head2;
        return head.next;
     }
    public ListNode sortInList (ListNode head) {//将链表一分为2
        // write code here
        if(head.next == null){
            return head;
        }
        ListNode left= head, mid = head.next ,right = head.next.next;
        while(right != null && right.next != null){//注意如果是双数链表的话，遍历到最末尾，right必为null
            left = left.next;
            mid = mid.next;
            right = right.next.next;
        }
        left.next = null;

     return merge(sortInList(head),sortInList(mid));  
    }
}