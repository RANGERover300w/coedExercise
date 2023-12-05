import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public int minPathSum (int[][] matrix) {
        // write code here
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        for(int i = 0;i < n;i++){
            for(int j = 0; j< m;j++){
                if(i==0&&j==0){
                    dp[i][j] = matrix[i][j];
                }else if(i == 0){
                    dp[i][j] = matrix[i][j] +dp[i][j-1];
                }
                else if(j == 0){
                    dp[i][j] = matrix[i][j] +dp[i-1][j];
                }else{
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + matrix[i][j];}
            }
        }
        return dp[n-1][m-1];
    }
}