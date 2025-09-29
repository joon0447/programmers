import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.charAt(0) == ')') return false;
        if(s.charAt(s.length()-1) == '(') return false;        
      
        for(char c : s.toCharArray()){
            if(c=='(') stack.push(c);
            else{
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
