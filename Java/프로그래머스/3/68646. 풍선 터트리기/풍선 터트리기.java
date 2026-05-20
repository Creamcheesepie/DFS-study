/*
배열의 길이가 1~100만이면 완전탐색시 시간이 초과될거고...

stack을 써서 찾아내기?
아 임의의 인접한 풍선을 펑!
흠...
자기보다 큰 수를 만나지 못하는 풍선은 무조건 터지게 되어 있음.
좌 우로 자기보다 작은 수가 있다면 무조건 사라지게 되어있음
Map 써서 최소값 관리를 해줘야하나?
최소값 관리를 어떻게하지?
*/

class Solution {
    public int solution(int[] a) {
        int answer = 2; // 양 끝단의 풍선은 무조건 남길 수 있음, 어떤 조건이든지 한쪽을 다 터트리고 더 작은거 한번 터트리면 땡!
        int n = a.length;
        
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        
        leftMin[0] = a[0];
        for(int i =1 ; i<n; i++){
            leftMin[i] = Math.min(a[i],leftMin[i-1]);
        }
        
        rightMin[n-1] = a[n-1];
        for(int i = n- 2; i> -1 ; i--){
            rightMin[i] = Math.min(a[i],rightMin[i+1]);
        }
        
        for(int i = 1;i < n-1; i++){
            int now = a[i];
            if(leftMin[i -1] < now && rightMin[i+1] < now) continue;
            answer++;
        }
        
        return answer;
    }
}