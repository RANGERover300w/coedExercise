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
     * @param k int整型 
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        if(head == null || head.next == null || k < 2){
            return head;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        ListNode cur = head;
        ListNode temp;
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }  
        for(int i = 1;i <= count/k;i++){
            for(int j= 1 ;j < k;j++){
                temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next; //此处为什么不能用cur？ 因为在内层循环中pre是不动的，要头插，如果是cur的话头就是动得了
                pre.next = temp;
                
            }
            pre = cur;
            cur = cur.next;
            //结束外层循环，向下移动一位开始第二层循环
        }
        return res.next;
    }
}