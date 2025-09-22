class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int translate = 0;
        int delete = 0;
        while(!s.equals("1")){
            delete += s.length() - s.replace("0", "").length();
            s = s.replace("0", "");
            s = Integer.toBinaryString(s.length());
            translate++;
        }
        
        answer[0] = translate;
        answer[1] = delete;
        
        return answer;
    }
}
