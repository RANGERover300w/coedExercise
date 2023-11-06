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
    public ListNode oddEvenList (ListNode head) {
        // write code here
        ListNode res = new ListNode(0);
        ListNode res2 = new ListNode(0);
        ListNode r = res2;
        ListNode r2 = res;
        ListNode cur =head;
        int  count = 1;
        while(cur != null){
            if(count % 2 == 0){
                res.next = cur;
                res=res.next; 
            }else{
                res2.next = cur;
                res2 = res2.next;
            }
            cur = cur.next;
            count++;
        }
        res.next = null;//无论什么链表倒数第二个的next因为没有下一个，所以不会断开但是因为奇数和偶数链表最后会相连，偶数排在奇数的后面所以，奇数最后一位的next会断开，但是如果原表位奇数，原表倒数第二位为偶数，其next不会自动断开，会造成死循环，需要手动断开。
       res2.next = r2.next;
       return r.next;
    }
}