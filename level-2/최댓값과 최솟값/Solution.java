class Solution {
    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        String[] arr = s.split(" ");
        for(String str : arr){
            int num = Integer.parseInt(str);
            if(min > num) min = num;
            if(max < num) max = num;
        }
        
        return min + " " + max;
    }
}
