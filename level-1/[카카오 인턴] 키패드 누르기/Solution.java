import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] keyboard = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 0, 11}
            };
        int[] leftLoc = new int[]{3,0};
        int[] rightLoc = new int[]{3,2};
        for(int number : numbers){
            if(number == 1 || number == 4 || number == 7){
                for(int i=0; i<keyboard.length; i++){
                    if(keyboard[i][0] == number){
                        leftLoc[0] = i;
                        leftLoc[1] = 0;
                        answer +="L";
                        break;
                    }
                }
            }
            else if(number == 3 || number == 6 || number == 9){
                for(int i=0; i<keyboard.length; i++){
                    if(keyboard[i][2] == number){
                        rightLoc[0] = i;
                        rightLoc[1] = 2;
                        answer +="R";
                        break;
                    }
                }
            }
            else{
                for(int i=0; i<keyboard.length; i++){
                    if(keyboard[i][1] == number){
                        double right = Math.abs(rightLoc[0]-i) + Math.abs(rightLoc[1]-1);
                        double left = Math.abs(leftLoc[0]-i) + Math.abs(leftLoc[1]-1);
                        if(right < left){
                            rightLoc[0] = i;
                            rightLoc[1] = 1;
                            answer +="R";
                        }else if(right >left){
                            leftLoc[0] = i;
                            leftLoc[1] = 1;
                            answer +="L";
                        }else{
                            if(hand.equals("right")){
                                rightLoc[0] = i;
                                rightLoc[1] = 1;
                                answer +="R";
                            }else{
                                leftLoc[0] = i;
                                leftLoc[1] = 1;
                                answer +="L";
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}
