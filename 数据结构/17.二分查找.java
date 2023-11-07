import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param nums int整型一维数组 
     * @param target int整型 
     * @return int整型
     */
    public int search (int[] nums, int target) {
        // write code here
        int l = 0;
        int r = nums.length-1;
        while(l <= r){//问什么要小于等于？ 只有一个数的时候无法进去判断，还有就是可能在最边上的时候需要等于。不然就会错过。
            int m = (l+r)/2;
            if(nums[m] == target){
                return m;
            }else if(nums[m] > target){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return -1;
    }
}