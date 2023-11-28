import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 判断岛屿数量
     * @param grid char字符型二维数组 
     * @return int整型
     */
     //遍历这个数组，（当前点为1）如果遇到语词典附近的1就置为0，之后继续遍历，再遇到就加1.
    public void bfs(char[][] grid,int i ,int j){
        int m = grid.length;
        int n= grid[0].length;
        //将此位置置为0
        grid[i][j] = '0';
        if(i-1>= 0 && grid[i-1][j] == '1'){
            //向上搜索。
            bfs(grid,i-1,j);
        }
        if(i+1<m && grid[i+1][j] == '1'){
            bfs(grid,i+1,j);
        }
        if(j + 1  < n&& grid[i][j+1] == '1'){
            bfs(grid,i,j+1);
        }
        if(j-1>=0 && grid[i][j-1] == '1'){
            bfs(grid,i,j-1);
        }
    }
    public int solve (char[][] grid) {
        // write code here
        if (grid.length == 0 ){
            return 0;
        }
        int count = 0;
        for(int i  = 0; i < grid.length;i++){
            for(int j = 0;j< grid[0].length;j++){
                if(grid[i][j] == '1'){
                    count++;
                    bfs(grid,i,j);
                }
            }
        }
        return count;
    }
}