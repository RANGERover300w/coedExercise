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

     //使用双指针解法
    public ListNode oddEvenList (ListNode head) {
        // write code here
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode next = head.next;
        ListNode n = next;
        while( next.next != null){
            //将next指针的下一个连接到pre的下一个
            pre.next = next.next; 
            //因为已经连接上了，因此向后移一个就是移动到了下一个奇数位
            pre = pre.next;
            //同理连接偶数位
            next.next = pre.next;
            if(next.next != null){
            next = next.next;
            }
            
        }
        //将偶数连接在奇数的末尾
        pre.next = n;
       return head;
    }
}