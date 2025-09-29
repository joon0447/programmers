import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    list.add(new int[]{i,j});
                }
            }
        }
        
        int lux = Integer.MAX_VALUE, luy = Integer.MAX_VALUE, rdx = 0, rdy = 0;
        
        for(int i=0; i<list.size(); i++){
            int[] arr = list.get(i);
            if(arr[0] < lux){
                lux = arr[0];
            }
            if(arr[1] < luy){
                luy = arr[1];
            }
            
            if(arr[0] > rdx){
                rdx = arr[0];
            }
            if(arr[1] > rdy){
                rdy = arr[1];
            }
        }
        
        
        int[] answer = new int[]{lux, luy, rdx+1, rdy+1};
        return answer;
    }
}
