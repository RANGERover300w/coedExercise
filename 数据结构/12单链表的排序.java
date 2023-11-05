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
    public ListNode sortInList (ListNode head) {
        // write code here
        ListNode cur = head;
        ListNode res = head;
        ListNode p = head;
        int count = 0;
        while (cur != null) //计数
        {
            count++;
            cur = cur.next;
        }
        int arr[] = new int[count];
        for(int i = 0; i < count;  i++){//将链表内容存进数组
            arr[i] = head.val;
            if(head.next  != null)
            head = head.next;
        }
        Arrays.sort(arr);
        for(int i = 0; i < count ; i++){//将数组内容再存进链表
            res.val = arr[i];
            if(res.next  != null)
            res = res.next;
        }
          
        return p;
    }
}