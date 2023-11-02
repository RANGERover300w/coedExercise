import java.util.*;
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow1 = pHead;
        ListNode slow2 = pHead;
        ListNode fast = pHead;
        while(fast.next != null && fast.next.next != null){//判断是否有环
            slow1 =slow1.next;
            fast = fast.next.next;
            if(fast == slow1){
                while(slow1.next!=null &&slow2.next != null){//通过计算距离，可得头到入口的距离等于第一次相遇的点到入口的距离 slow1从头开始
                    if(slow1 == slow2){
                        return slow1;
                    }
                    slow1 = slow1.next;
                    slow2 = slow2.next;
                }
            }
        }
        return null;
    }
}
