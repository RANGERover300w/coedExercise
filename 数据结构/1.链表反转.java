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
    public ListNode ReverseList (ListNode head) {
        // write code here
        if(head == null){
            return null;
        }
        ListNode pre = null;
            ListNode next = null;
        while(head != null){
            next = head.next;
            //将下一个值保存下来，以免丢失
            head.next = pre;
            //将此节点的链反转
            pre = head;
            //此节点向后移
            head = next;
            //此节点向后移
        }
        return pre;
        //如果反转成功，pre就是头节点，head已经是空
    }
}