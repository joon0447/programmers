import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        Map<Integer, int[]> map = new HashMap<>();
        int sort = 0;
        switch(sort_by){
            case "code":
                sort = 0;
                break;
            case "date":
                sort = 1;
                break;
            case "maximum":
                sort = 2;
                break;
            case "remain":
                sort = 3;
                break;
        }
        switch(ext){
            case "code":
                for(int i=0; i<data.length; i++){
                    if(data[i][0] < val_ext) map.put(data[i][sort], data[i]);
                }
                break;
            case "date":
                for(int i=0; i<data.length; i++){
                    if(data[i][1] < val_ext) map.put(data[i][sort], data[i]);   
                }
                break;
            case "maximum":
                for(int i=0; i<data.length; i++){
                    if(data[i][2] < val_ext) map.put(data[i][sort], data[i]);    
                }
                break;
            case "remain":
                for(int i=0; i<data.length; i++){
                    if(data[i][3] < val_ext) map.put(data[i][sort], data[i]);   
                }
                break;
        }
        
        Map<Integer, int[]> sortedMap = new TreeMap<>(map);
        for(Map.Entry<Integer, int[]> entry : sortedMap.entrySet()){
            list.add(entry.getValue());
        }
        
        return list.toArray(new int[list.size()][]);
        
    }
}
