class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int video_len_sec = toSeconds(video_len);
        int pos_sec = toSeconds(pos);
        int op_start_sec = toSeconds(op_start);
        int op_end_sec = toSeconds(op_end);
        if(op_start_sec <= pos_sec && pos_sec < op_end_sec) pos_sec = op_end_sec;
        for(String cmd : commands){
            if(cmd.equals("next")){
                if(video_len_sec - pos_sec < 10) pos_sec = video_len_sec;
                else pos_sec += 10;
            }else{
                if(pos_sec < 10) pos_sec = 0;
                else pos_sec -= 10;
            }
            if(op_start_sec <= pos_sec && pos_sec < op_end_sec) pos_sec = op_end_sec;
        }
        
        return String.format("%02d:%02d", pos_sec / 60, pos_sec % 60);
    }
    
    static int toSeconds(String timeStr){
        String[] parts = timeStr.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }
}
