import java.util.*;
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
      while(!stack2.isEmpty()){
         int n = stack2.pop();
        stack1.push(n);
      }
      stack1.push(node);
    }
    
    public int pop() {
        while(!stack1.isEmpty()){
        int n = stack1.pop();
        stack2.push(n);
      }
        return stack2.pop();
    }
}
