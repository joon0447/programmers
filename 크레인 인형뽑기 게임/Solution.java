import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<moves.length; i++){
            int move = moves[i]-1;
            for(int j=0; j<board.length; j++){
                if(board[j][move] != 0){
                    int doll = board[j][move];
                    board[j][move] = 0;
                    
                    if(!stack.isEmpty()){
                        if(stack.peek() == doll){
                        answer +=2;
                        stack.pop();
                        }else{
                            stack.push(doll);
                        }
                    }else{
                        stack.push(doll);
                    }
                    break;
                }
            }
        }
        return answer;
    }
}
