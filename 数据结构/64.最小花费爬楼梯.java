import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param cost int整型一维数组 
     * @return int整型
     */
    public int minCostClimbingStairs (int[] cost) {
        // write code here
        int co[] = new int[cost.length + 1];
        for(int i = 2; i <= cost.length;i++){    
            co[i] = Math.min(co[i -1] + cost[i - 1],co[i - 2] + cost[i - 2]);
        }
        return co[cost.length];
    }
}