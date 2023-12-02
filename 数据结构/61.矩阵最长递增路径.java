import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 递增路径的最大长度
     * @param matrix int整型二维数组 描述矩阵的每个数
     * @return int整型
     */
    public int solve (int[][] matrix) {
        // write code here
        int max = 0;
        for(int i = 0; i< matrix.length;i++){
            for(int j = 0; j < matrix[i].length; j++){
                max = Math.max(max,dfs(matrix,i,j,-1));
            }
        }
        return max;
    }
    public int dfs(int[][] matrix,int i,int j,int pre){
        int max = 0;
        if(matrix[i][j] <= pre){
            return 0;
        }
        if(i>0){
            max = Math.max(max, dfs(matrix, i - 1, j, matrix[i][j]));
        }
        if(j>0){
             max = Math.max(max, dfs(matrix, i, j - 1, matrix[i][j]));
        }
        if(i < matrix.length - 1){
            max = Math.max(max, dfs(matrix, i + 1, j, matrix[i][j]));
        }
        if(j < matrix[i].length - 1){
            max = Math.max(max, dfs(matrix, i, j + 1, matrix[i][j]));
        }
        return max+1;
    }
}