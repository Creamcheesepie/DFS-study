## 문제 1. [바닥 장식](https://www.acmicpc.net/problem/1388)
### 내용
`-`와 `|`로 이루어진 바닥 장식이 주어진다.
`-`가 같은 행에서 인접해 있다면 두개는 같은 나무 판자이고
`|`가 같은 열에서 인접해 있다면 두개는 같은 나무 판자이다.
방 바닥을 장식하는데 필요한 나무 판자의 개수를 출력하는 프로그램을 작성하시오.
- 입력 : 첫째 줄에 세로크기 N과 가로 크기 M이 주어진다. 두번째 줄부터 N개의 줄에 M개의 문자가 주어진다. 이것은 바닥 장식 모양이고 `-`과 `|`로만 이루어져 있다. N 과 M은 50 이하인 자연수이다. 



### 문제 접근
이게 DFS...? 싶은 구석이 있는 문제다. DFS 써도 풀리지만 while문 써도 풀릴 것 같기 때문이다. 
하지만 DFS를 쓰는게 좀 더 직관적이지 않을까 싶은 생각도 든다.
1. 일단 입력받은 데이터를 정리하여 n과 m을 정하고, 입력받은 문자를 2차원 문자 배열로 만든다.
2. 1개의 나무 판자로 확인 된 건 저장할 visited 배열을 만든다
3. 첫번째 행부터 진행하며 연속되지 않은 판자를 만날때 +1을 해주고 해당 판자에 연속된 하나의 판자를 visited 해준다 . 
4. 어떤 걸 만났는지에 따라 분기처리를 해주면 될 것 같다.

근데 확실히 return만 해주면 되는 프로그래머스 문제 풀다가 오랜만에 백준 쓰려니 어색하다...

### 풀이
```java
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    boolean[][] visited;
    char[][] floor;
    int answer = 0;
    
    public static void main(String args){

        private BufferedReader br = new BufferedReader(new BufferedInputStream(System.in));
        private BufferedWriter bw = new BufferedWriter(new BufferedOutputStream(System.out));
        String sizeStr = br.readLine();
        String[] bits = sizeStr.split(" ");
        int n = Integer.parseInt(bits[0]); // 세로 크기
        int m = Integer.parseInt(bits[0]); // 가로 크기
        floor = new char[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            floor[i] = line.toCharArray();
        }
        
        for(int i = 0; i< n; i++){
            for(int j = 0; j<m; j++){
                if(visited[n][m]) continue;
                visited[n][m] = true;
                answer ++;
                bfs(n,m,floor[n][m]);
            }
        }
        
        bw.write(answer+"");
        bw.flush();
        bw.close();
    }
    
    private void bfs(int n, int m,char c){
        if(n +1 >= floor.length || m+1 >= floor.length)return;
        
        if(c == floor[n+1][m]){
            visited[n+1][m] = true;
            bfs(n+1,m,c);
        }
        if(c == floor[n][m+1]){
            visited[n][m+1] = true;
            bfs(n,m+1,c);
        }
        
    }
}

```
