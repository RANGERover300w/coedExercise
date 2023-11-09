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
        for(int i = 0 ; i < nums.length - 1; i++){
            if(nums[i + 1] > nums[i]){
                if((i + 2) <= nums.length -1){
                if(nums[i + 2] < nums[i + 1]){
                    return i + 1;
                }
                }else {
                    return i + 1;
                }
            }
        }
        return 0;
    }
}