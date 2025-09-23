class Solution {
    public int solution(int n) {
        String nB = Integer.toBinaryString(n);
        nB = nB.replace("0", "");
        for(int i=n+1;;i++){
            String iB = Integer.toBinaryString(i);
            if(nB.length() == iB.replace("0", "").length()){
                return i;
            } 
        }
    }
}
