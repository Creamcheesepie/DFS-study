## 문제 1. [무인도 여행](https://school.programmers.co.kr/learn/courses/30/lessons/154540)
### 내용

무인도로 여행을 가기 위해 지도를 보고 있다. 
지도에는 바다와 무인도들에 대한 정보가 표시되어 있으며, 지도는 1x1 크기의 사각형들로 이루어져 있다. 
격자의 각 칸은 X 또는 1~9사이의 자연수로 적혀있다. X는 바다를 의미한다. 숫자는 식량을 나타내며, 상, 하, 좌, 우로 연결된 칸의 숫자를 전부 합하면 해당 무인도에서 얼마나 머물 수 있는지를 알 수 있다.
각 섬에서 지낼 수 있는 날을 알아보시오.

### 문제 접근
일단, DFS를 통해 이어진 모든 섬이 총 개수를 구해서 리스트에 더하고 체크되지 않은 섬을 기준으로 다시 시작하면 된다.
day2의 네트워크 문제에서 조금 더 복잡해진 케이스라고 생각된다. 

1. 일단 방문 여부를 확인할 배열을 설정
2. 이것도 이전과 비슷하게 배열의 처음부터 끝까지 진행되게 함.
3. dfs 안에서 한번 더 배열을 확인해야 하는 점이 이전의 네트워크와의 차이점
4. 즉, 첫 탐색 지점에 무조건 시작점이 있다는 보장이 없다는 차이점이 존재.
5. + 상하좌우의 탐색이 추가됨, 그 외의 어려운건 없는거 같은데?, 그리고 이번에도 총합을 어떻게 계산하느냐가 죅금 골때리는 것 같음 ㅋㅋ....하


### 의사 코드
```java
List<Integer> answer;
boolean[][] visited;

String[] maps;
visited = new boolean[maps.length][maps[0].length];
List<Integer> answer;
int count = 0;
for(int x to maps.length){
    String str = maps[x];
        for(int y = 0; y<str.length() ; y++){
            char c = str.charAt(j);
            if(c != 'X' && !visited){
                visited[x][y] = true;
                count += Integer.valueOf(c);
                dfs(x,y); // 여기에서 dfs 반복이 끝나면 아래로 진행되고 다음으로 갈 테니
                answer.add(count); // 여기서 추가;
                count = 0;
            }
        }
        return answer;
}

void dfs(int x, int y){
   if(x-1 >0 && !visited[x-1][y] && maps[][]) {
       visited[x-1][y] = true;
       dfs(x-1,y);
    }
    ...// 각 방향별 반복
}

```

조금 반복이 많이 되는 감이 없잖아 있나? 아 어차피 1번 갔다오면 체크되어서 또 안가니까 괜찮네~
