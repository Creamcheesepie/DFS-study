package day4;

import java.io.*;

public class Floor {
    static boolean[][] visited;
    static char[][] floor;
    static int answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String sizeStr = br.readLine();
        String[] bits = sizeStr.split(" ");
        int n = Integer.parseInt(bits[0]); // 세로 크기
        int m = Integer.parseInt(bits[1]); // 가로 크기
        floor = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            floor[i] = line.toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    answer++;
                    dfs(i, j, floor[i][j]);
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    private static void dfs(int n, int m, char c) {

        if (n+1 < floor.length && c == floor[n + 1][m] && c == '|' ) {
            visited[n + 1][m] = true;
            dfs(n + 1, m, '|');
        }

        if (m+1 < floor[n].length && c == floor[n][m + 1] && c == '-' ) {
            visited[n][m + 1] = true;
            dfs(n, m + 1, '-');
        }

    }
}
