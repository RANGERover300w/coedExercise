import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param nums int整型一维数组 
     * @return int整型
     */
    public int findPeakElement (int[] nums) {
        // write code here
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid + 1] > nums[mid]){//使用二分法，找到中间值如果右侧的值比这个数大则证明右侧有峰值，反之则证明左侧有峰值，此方法就是寻找区域内最大值（此区域并不是全部区域而是根据二分法的中值确定的），当left,right相遇就证明找到了最大值。
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right;
    }
}