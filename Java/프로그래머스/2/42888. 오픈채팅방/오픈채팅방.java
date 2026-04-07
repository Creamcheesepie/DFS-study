import java.util.*;

class Solution {
    String enter = "Enter";
    String leave = "Leave";
    String change = "Change";
    String leaveMsg = "님이 나갔습니다.";
    String enterMsg = "님이 들어왔습니다.";
    
    
    public String[] solution(String[] record) {
        Map<String,String> userNickNameMap = new HashMap<>();
        List<String[]> chatList = new ArrayList<>();
        
        for(String chat : record){
            String[] bits = chat.split(" ");
            String cmd = bits[0];
            String uid = bits[1];
            
            
            if(cmd.equals(enter)){
                String nickName = bits[2];
                userNickNameMap.put(uid,nickName);
                chatList.add(new String[]{uid,enterMsg});
            } else if(cmd.equals(leave)){
                chatList.add(new String[]{uid,leaveMsg});
            } else if(cmd.equals(change)){
                String nickName = bits[2];
                userNickNameMap.put(uid,nickName);
            }
        }
        
        String[] answer = new String[chatList.size()];
        for(int i = 0; i<chatList.size(); i++){
            String[] bits = chatList.get(i);
            String msg = userNickNameMap.get(bits[0]) + bits[1];
            answer[i] = msg;
        }
        
        return answer;
    }
}