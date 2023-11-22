import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param a int整型一维数组 
     * @param n int整型 
     * @param K int整型 
     * @return int整型
     */

    //做题思路是使用快排，大元素在左，小元素在右如果快排的基数等于  交换过后等于k+1证明此数为第k个值
    public int findKth (int[] a, int n, int K) {
        // write code here
       return partition(a,0,n-1,K);
    }
    public int partition(int[] a ,int left ,int right,int K){
        int t;
        int i = left;
        int j = right;
        int temp = a[left];

        while(i < j){
            while(temp >= a[j] && i < j){
                j--;
            }
            while(temp <= a[i] && i < j){
                i++;
            }
            if(i < j){
                t = a[j];
                a[j] = a[i];
                a[i] = t;
            }
        }
        a[left] = a[j];
        a[j] = temp;
        if(j + 1 == K){
            return a[j];
        }else if((j+1) > K ){
           return partition(a,left,j-1,K);
        }else{
           return partition(a,j+1,right,K);
        }
    }
}