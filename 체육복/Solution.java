import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n];
        Arrays.fill(student, 1);
        
        //도난 처리
        for(int i : lost){
            student[i-1]--;
        }
        
        //여벌 학생 처리
        for(int i : reserve){
            student[i-1]++;
        }
        
        for(int i=0; i<student.length; i++){
            int num = student[i];
            if(num == 0){
                if(i==0){
                    if(student[i+1] == 2){
                        student[i] = 1;
                        student[i+1]--;
                    }
                }
                else if(i==student.length-1){
                    if(student[i-1] == 2){
                        student[i] = 1;
                        student[i-1]--;
                    }
                }
                else{
                    if(student[i-1] == 2 || student[i+1] == 2){
                        student[i] = 1;
                        if(student[i-1] == 2) student[i-1]--;
                        else student[i+1]--;
                    }
                }
                
            }
        }
        
        int answer = 0;
        for(int i : student){
            if(i==1 || i==2) answer++;
        }
        return answer;
    }
}
