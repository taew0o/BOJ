class Solution {
    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        //각 정보를 ':' 기준으로 split
        String[] len_split = video_len.split(":"), pos_split = pos.split(":"), op_start_split = op_start.split(":"),
                op_end_split = op_end.split(":");

        //String -> int로 변환
        int lenTime = Integer.parseInt(len_split[0]) * 60 + Integer.parseInt(len_split[1]),
                posTime = Integer.parseInt(pos_split[0])* 60 + Integer.parseInt(pos_split[1]),
                opStartTime = Integer.parseInt(op_start_split[0]) * 60 + Integer.parseInt(op_start_split[1]),
                opEndTime = Integer.parseInt(op_end_split[0]) * 60 + Integer.parseInt(op_end_split[1]);

        if(opStartTime <= posTime && posTime <= opEndTime){
            posTime = opEndTime;
        }

        for(String command : commands){
            if(command.equals("prev")){
                posTime = Math.max(0, posTime - 10);
            }
            else{
                posTime = Math.min(lenTime, posTime + 10);
            }
            //오프닝 구간에 걸린 경우 다시 오프닝 끝으로 이동
            if(opStartTime <= posTime && posTime <= opEndTime){
                posTime = opEndTime;
            }
        }

        return String.format("%02d", posTime / 60) + ":" + String.format("%02d", posTime % 60);
    }
}