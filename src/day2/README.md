## 문제 1. [네트워크](https://school.programmers.co.kr/learn/courses/30/lessons/43162?language=java)
### 내용
네트워크란 컴퓨터 상호간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다.
컴퓨터의 대수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때,
네트워크의 개수를 return하도록  solution 함수를 작성하시오

### 제한사항
컴퓨터의 개수 n은 1 이상 200이하인 자연수입니다. 
각 컴퓨터는 0부터 n-1인 정수로 표현됩니다.
i번 컴퓨터와 j번 컴퓨가 연결되어 있으면 `computers[i][j]` 를 1로 표현합니다.<br/>
`computers[i][i]` 는 항상 1입니다. 

### 문제 접근
일단 생각해보자. 네트워크의 한 묶음은 어떻게 찾을 수 있을까?<br/>
한 범위에서 방문할 수 있는 노드를 '전부 탐색'하면 이게 하나의 네트워크가 된다.<br/>
하나의 노드에서 순회를 완료하면 체크 여부를 전부 방문함으로 바꾸고, count +1 해준다.<br/>
한 덩어리의 네트워크 체크를 어떻게 해주지? -> 이것에 대한 분기처리!<br/>
1. 처음에 방문하지 여부를 확인하고, 방문하지 않았다면 count +1;
2. DFS를 통해 해당 네트워크 내부 전체의 노드들을 방문함.
3. 다음 방문하지 않은 노드를 찾음 == 다른 범위의 네트워크 -> count +1 하고 다시 2번 실행
4. 남은 노드가 없을때까지 반복한 후 결과를 반환하면 됨.

2번에서 3번으로 넘어 갈 때가 문제인데...
지금은 for문을 통해서 다음 노드로 넘어가는 것을 구현하고, 다음 노드에서 다시 dfs를 진행하는 식으로 구현해 두었다.
### 의사코드
```java
int[][] computers;
boolean[] visited; // 어차피 방문하는
int cnt = 0;

for(i = 0 -> computes.length){
        if(!visited[i]){
            cnt++;
            dfs(i);
        }
        return cnt;
}


void dfs(int i){
    int[] com = computers[i];
    for(i = 0 -> com.length){
        if(!visited[i] && com[i] == 1 ){
            visited[i] = true;
            dfs(i);
        }
    }
}


```
