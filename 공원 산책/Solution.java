import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        String[][] parkArr = new String[park.length][park[0].length()];
        List<int[]> list = new ArrayList<>();
        int h=0, w=0;
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[i].length(); j++){
                char ch = park[i].charAt(j);
                if(ch == 'S'){
                    h = i;
                    w = j;
                }
                else if(ch=='X'){
                    list.add(new int[]{i,j});
                }
                parkArr[i][j] = park[i].charAt(j) + "";
            }
        }
        
        for(String route : routes){
            String direct = route.split(" ")[0];
            int distance = Integer.parseInt(route.split(" ")[1]);
            boolean pass = true;
            switch(direct){
                case "E":
                    if(w + distance >= parkArr[h].length){
                        continue;
                    }
                    for(int[] arr : list){
                        int xw = arr[1] , xh= arr[0];
                        if(h == xh && w < xw && w+distance >= xw){
                            pass = false;
                            break;
                        }
                    }
                    if(pass) w += distance;
                    break;
                case "W":
                    if(w - distance < 0){
                        continue;
                    }
                    for(int[] arr : list){
                        int xw = arr[1], xh =arr[0];
                        if(xh==h && w > xw && w-distance <= xw){
                            pass = false;
                            break;
                        }    
                    }
                    if(pass) w -= distance;
                    break;
                case "N":
                    if(h -distance < 0){
                        continue;
                    }
                    for(int[] arr : list){
                        int xh = arr[0], xw = arr[1];
                        if(xw == w&& h > xh && h-distance <= xh){
                            pass = false;
                            break;
                        }    
                    }
                    if(pass) h-=distance;
                    break;
                case "S":
                    if(h+distance >= parkArr[h].length){
                        continue;
                    }
                    for(int[] arr : list){
                        int xh = arr[0], xw = arr[1];
                        if(xw == w && h < xh && h+distance >= xh){
                            pass = false;
                            break;
                        }    
                    }
                    if(pass) h+=distance;
                    break;
            }
        }
        
        int[] answer = new int[]{h,w};
        return answer;
    }
}
