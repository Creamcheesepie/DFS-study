package day2;

public class NetworkSolve {
    public static void main(String[] args) {

    }

    private static int[][] coms;
    private static boolean[] visited;
    public static int solution(int[][] computers){
        int answer = 0;
        coms = computers;
        visited = new boolean[computers.length];

        for(int i = 0; i < computers.length; i++){
            if(!visited[i]) {
                dfs(i);
                answer ++;
            }
        }
        return answer;
    }

    public static void dfs(int index){
        int[] com = coms[index];
        for(int i = 0; i < visited.length; i++){
            if(!visited[i] && com[i] == 1 ){
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
