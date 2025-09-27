import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i : arr){
            if(stack.isEmpty()) stack.push(i);
            else{
                int num = stack.pop();
                stack.push(lcm(num, i));
            }
        }
        
        return stack.pop();
    }
    
    int lcm(int a, int b) {
        int max = Math.max(a,b);
        int gcd = 1;
        for(int i = max; i>0; i--){
            if(a%i==0 && b%i==0){
                gcd = i;
                break;
            }
        }
        
        return a*b/gcd;
    }
}
