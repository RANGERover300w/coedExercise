import java.util.*;
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p2;
        while(pHead1 != null){//遍历第一个链表
            p2 = pHead2;
            while(p2 != null){//遍历第二个链表
                if(pHead1 == p2){//如果有相等就返回
                return pHead1;
            }
            p2 = p2.next;
            }
            pHead1 = pHead1.next;
        }
        return null;
    }
}
