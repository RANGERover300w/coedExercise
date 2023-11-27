import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param num int整型一维数组 
     * @return int整型ArrayList<ArrayList<>>
     */
     //使用递归，将遇到的数存放进临时数组中，并将对那个的i值存放进是否使用过的值中，开始遍历数组，没加过就加入临时数组，加过了就continue，然后递归，丛0开始遍历，遇到没加过的就加进去，全部加完，回溯删除temp【i】，返回上一层，上一层的i继续往后走。
    public void recursion(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp,int num[],boolean vis[]){
       //如果数组满了就将数组放进temp中
        if(temp.size() == num.length){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = 0 ; i < num.length; i++){
            if(vis[i]){
                continue;
            }
            if(i > 0 && num[i] == num[i-1]&&vis[i-1])
            continue;
            vis[i] = true;
            temp.add(num[i]);
            recursion(res,temp,num,vis);
            vis[i] = false;
            temp.remove(temp.size() - 1);
        }
        }
   
     public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // write code here
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
      boolean vis[] = new boolean[num.length];
      Arrays.fill(vis, false);
      ArrayList<Integer> temp = new ArrayList<>();
      recursion(res,temp,num,vis);
      return res;
    }
}