class Solution {
    private int rsOne = 0;
    private int rsZero = 0;
    
    public int[] solution(int[][] arr) {
        int[] answer = {};
        int oneCnt = 0;
        int zeroCnt = 0;
        int n = arr.length;
        // DP? 아니면 단순 시뮬레이션? DFS?
        
        sq(arr,0,0,n);
        
        
        return new int[]{rsZero,rsOne};
    }
    
    private void sq(int[][] arr, int x,int y, int size){
        int firstNumb = arr[x][y];
        int zeroCnt = 0;
        int oneCnt = 0;
        for(int i = x; i < x + size; i++){
            for(int j = y; j <y + size; j++){
                if(arr[i][j] == 0) zeroCnt ++;
                if(arr[i][j] == 1) oneCnt ++;
                if(firstNumb != arr[i][j]) break;
            }
        }
        if(zeroCnt == 0) rsOne ++;
        else if(oneCnt == 0) rsZero++;
        else {
            int nextSize = size/2;
            sq(arr, x, y, nextSize);
            sq(arr, x+nextSize, y,nextSize);
            sq(arr, x , y + nextSize, nextSize);
            sq(arr, x+nextSize, y+nextSize, nextSize);
        }
    }
    
}