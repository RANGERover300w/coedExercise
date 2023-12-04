import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param m int整型 
     * @param n int整型 
     * @return int整型
     */
    public int uniquePaths (int m, int n) {
        // write code here
        int dp[][] = new int[m+1][n+1];
        if(m < 2|| n < 2){
            return 1;
        }
        for(int i = 1 ; i <= m ;i++){
            dp[i][1] = 1;
        }
        for(int j = 1; j <= n; j++){
            dp[1][j] = 1;
        }
        for(int i = 2; i <= m; i++){
            for(int j = 2; j <= n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}