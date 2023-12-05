import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 最少货币数
     * @param arr int整型一维数组 the array
     * @param aim int整型 the target
     * @return int整型
     */
    //用dp记录，从一块钱开始一点一点网上算，直到等于aim。
    public int minMoney (int[] arr, int aim) {
        // write code here
        if (aim < 1)
            return 0;
        int[] dp = new int[aim + 1];
        //dp[i]表示凑齐i元最少需要多少货币数
        Arrays.fill(dp, aim + 1);
        dp[0] = 0;
        for(int i = 1 ; i <= aim;i++ ){
            for(int j = 0 ;j < arr.length;j++){
                if(arr[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                }
            }
        }
     return dp[aim] > aim ? -1 : dp[aim];
    }
}