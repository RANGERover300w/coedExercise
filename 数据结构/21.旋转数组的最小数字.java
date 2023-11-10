import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param nums int整型一维数组 
     * @return int整型
     */
    public int minNumberInRotateArray (int[] nums) {
        // write code here
        if(nums.length == 0){
            return 0;
        }
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            int m = (i + j)/2;
            if(nums[m] < nums[j]) j = m;
            else if(nums[m] > nums[j]) i = m + 1;
            else j--;
        }
        return nums[i];
    }
}
//此题应该注意旋转数组的特性，用二分法将数组分开，中间的值如果大于末尾的值证明左面的数全是大数，所以向右查找。如果小于证明此区域处于顺序，逐步缩小范围，直到找到最小的，此时i，j相遇。      
