import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param nums int整型一维数组 
     * @return int整型
     */
     //将数组中的元素放金hashmap中
    public int minNumberDisappeared (int[] nums) {
        // write code here
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],1);
        }
        int res = 1;
        while(map.containsKey(res))
        res++;
        return res;
    }
}