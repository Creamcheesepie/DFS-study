import java.util.*;

class Solution {
    String answer = "";
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets,(t1, t2) -> t1[1].compareTo(t2[1]));
        boolean[] visited = new boolean[tickets.length];
        StringBuilder sb = new StringBuilder();
        sb.append("ICN");
        dfs(tickets,"ICN","ICN",0,visited);
        return answer.split(" ");
    }
    
    private void dfs(String[][] tickets, String airPort, String path, int level, boolean[] visited){
        if(level == tickets.length){
            answer = path;
            return ;
        }
        
        for(int i = 0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(airPort)){
                visited[i] = true;
                dfs(tickets,tickets[i][1],path + " " + tickets[i][1] ,level + 1,visited);
                visited[i] = false;
            }
            if(!answer.isBlank()) return;
        }
        
    }
}