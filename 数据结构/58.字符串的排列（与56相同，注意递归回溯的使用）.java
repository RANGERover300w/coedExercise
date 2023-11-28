import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param str string字符串 
     * @return string字符串ArrayList
     */
    public void recursion(ArrayList<String> res,char[] str,StringBuffer temp , boolean[] vis){
        if(temp.length() == str.length){
            res.add(new String(temp));
        }
        for(int i = 0; i< str.length;i++){
            if(vis[i]){
                continue;
            }
            if(i>0 && str[i] == str[i-1] && !vis[i-1]){
                continue;
            }
            vis[i] = true;
            temp.append(str[i]);
            recursion(res,str,temp,vis);
            vis[i] = false;
            temp.deleteCharAt(temp.length()-1);
        }
    }
    public ArrayList<String> Permutation (String str) {
        // write code here
        ArrayList<String> res = new ArrayList<String>();
        if(str.length() == 0|| str == null)
        return res;
        char[] str1 = str.toCharArray();
        Arrays.sort(str1);
        StringBuffer temp = new StringBuffer();
        boolean[] vis = new boolean[str1.length];
        recursion(res,str1,temp,vis);
        return res;
    }
}