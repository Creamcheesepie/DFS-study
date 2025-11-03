package day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DesertIslandTrip {
    public static void main(String[] args) {
        String[] maps;

    }

    static boolean [][] visited;
    static int count = 0;
    static List<Integer> answerList = new ArrayList<>();
    static String[] fmaps;
    public static int[] solution(String[] maps){
        fmaps = maps;
        visited = new boolean[maps.length][maps[0].length()];
        for(int i = 0; i<maps.length; i ++){
            for(int j = 0; j<maps[0].length(); j++){
                if(maps[i].charAt(j) == 'X' || visited[i][j])  continue;

                visited[i][j] = true;
                dfs(i,j);
                answerList.add(count);
                count = 0;
            }
        }
        if(answerList.size() == 0) return new int[] {-1};
        int[] answer = new int[answerList.size()];
        for(int i = 0; i<answerList.size(); i ++) answer[i] = answerList.get(i);
        Arrays.sort(answer);
        return answer;
    }

    public static void dfs(int i, int j ){
        if(i-1 > -1 && !visited[i-1][j] && fmaps[i-1].charAt(j) != 'X'){
            count+= Integer.parseInt(String.valueOf(fmaps[i-1].charAt(j)));
            visited[i-1][j] = true;
            dfs(i-1,j);
        }
        if(i+1 < fmaps.length && !visited[i+1][j] && fmaps[i+1].charAt(j) != 'X'){
            count+= Integer.parseInt(String.valueOf(fmaps[i+1].charAt(j)));
            visited[i+1][j] = true;
            dfs(i+1,j);
        }
        if(j-1 > -1 && !visited[i][j-1] && fmaps[i].charAt(j-1) != 'X'){
            count+= Integer.parseInt(String.valueOf(fmaps[i].charAt(j-1)));
            visited[i][j-1] = true;
            dfs(i,j-1);
        }
        if(j+1 < fmaps[i].length() && !visited[i][j+1] && fmaps[i].charAt(j+1) != 'X'){
            count+= Integer.parseInt(String.valueOf(fmaps[i].charAt(j+1)));
            visited[i][j+1] = true;
            dfs(i,j+1);
        }

    }
}
