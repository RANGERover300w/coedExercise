import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param n int整型 the n
     * @return int整型
     */
    private int res;
    public boolean isValid(int pos[],int row,int col){
        //遍历已经存在的点
        for(int i = 0 ; i < row; i++){
            //不能同行同列，同斜线
            if(i == row || col == pos[i] ||  Math.abs(row -i) == Math.abs(col - pos[i])){
                return false;
            }
        }
        return true;
    }
    public void recursion(int n, int row,int pos[]){
        if(row == n){
        res++;
        return;
        }
        for(int i = 0; i < n;i++){
            if(isValid(pos,row,i)){
                pos[row] = i;
                recursion(n,row+1,pos);
            }
        }
    }
    public int Nqueen (int n) {
        // write code here
        res = 0;
        int[] pos = new int[n];
        Arrays.fill(pos,0);
        recursion(n,0,pos);
        return res;
    }

}