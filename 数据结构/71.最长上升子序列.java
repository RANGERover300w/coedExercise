import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 给定数组的最长严格上升子序列的长度。
     * @param arr int整型一维数组 给定的数组
     * @return int整型
     */
    //做题思路就是新建数组dp【】记录的就是到词典的最长升子序列
    //首先依次以数组元素为基点，再从第一个点遍历到基点。
    //如果此点小于基点，并且，这个往里添加是按顺序的，dp[]每个位置只能修改一次
    public int LIS (int[] arr) {
        // write code here
        if(arr.length == 0){
            return 0;
        }
        int res = 1;
        int dp[] = new int[arr.length];
        Arrays.fill(dp, 1);
        for(int i = 1; i < arr.length;i++){
            for(int j = 0; j< i;j++){
                //这个数比基点大，证明基点能够加进数组中，并且还要此点维护长度+1 大于 基点 ，证明基点能够加进数组中且长度会增加
                if(arr[j] < arr[i] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    res = Math.max(res,dp[i]);
                }
            }
        }
        return  res;
    }
}