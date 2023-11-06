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
     * @param head ListNode类 the head
     * @return bool布尔型
     */
     //arraylist可以用colection的方法，直接反转。
     //将链表存入数组中直接反转在比较。因为会问结构，反转过后依旧是相等的
     //自己的方法是找到中点，后半部分反转，再比较。
    public boolean isPail (ListNode head) {
        // write code here
        ArrayList<Integer> nums = new ArrayList<Integer>();
        while(head != null){
            nums.add(head.val);
            head = head.next;
        }
        ArrayList<Integer> temp = new  ArrayList<Integer>();
        temp = (ArrayList<Integer>)nums.clone();
        Collections.reverse(temp);
        for(int i = 0; i< nums.size();i++){
            int x = nums.get(i);
            int y = temp.get(i);
            if(x != y)
            return false;
        }
        return true;
    }
}