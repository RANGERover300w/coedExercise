import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param num int整型一维数组 
     * @return int整型ArrayList<ArrayList<>>
     */

     //做题思路是，循环以index为基数进行交换，交换完递归index+1，从这以后就停止继续递归不会交换数字，直到所有都结束完毕，i开始动的时候才开始再次发生一次交换，只有i动的时候才进行交换，首次进入递归并不会发生交换。
    public ArrayList<Integer> swap(ArrayList<Integer> num, int i,int j){
        int temp = num.get(j);
        num.set(j,num.get(i));
        num.set(i,temp);
        return num;
    }
    public ArrayList<ArrayList<Integer>> recursion(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> num,int index){
        //因为i动一次只会进行一次交换，首次进行递归不会进行交换，所以当满足条件之后就代表一种结果
        if(index == num.size()-1){
            res.add(num);
        }
        //遍历数组
        for(int i = index; i< num.size();i++){
            //首次进入这个递归i=index不会进入递归
            swap(num,i,index);
            //i变动一次之后交换之后，会一直进行index+1，会是一直是第一次递归，什么也不会改变，直到index == num.size()-1
            recursion(res,num,index+1);
            //恢复原样
            swap(num,i,index);
        }
        return res;
    }
    public ArrayList<ArrayList<Integer>> permute (int[] num) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> nums= new ArrayList<>();
        for(int i = 0;i < num.length;i++){
            nums.add(num[i]);
        }
         res = recursion(res,nums,0);
         return res;
    }
}