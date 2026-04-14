class Solution {
    int rsZero = 0;
    int rsOne = 0;
    
    public int[] solution(int[][] arr) {
        sq(arr,0,0,arr.length);
        return new int[] {rsZero, rsOne};
    }
    
    private void sq(int[][] arr, int x,int y, int size){
        int firstNumber = arr[x][y];
        int zeroCnt = 0;
        int oneCnt = 0;
        
        for(int nx = x; nx<x + size; nx++){
            for(int ny = y; ny<y + size; ny++){
                if(arr[nx][ny] == 0) zeroCnt++;
                if(arr[nx][ny] == 1) oneCnt++;
                if(firstNumber != arr[nx][ny]) break;
            }
        }
        
        if(zeroCnt == 0) rsOne++;
        else if(oneCnt == 0) rsZero++;
        else {
            int nextSize = size/2;
            sq(arr,x,y, nextSize);
            sq(arr,x + nextSize,y, nextSize);
            sq(arr,x,y + nextSize, nextSize);
            sq(arr,x + nextSize,y + nextSize, nextSize);
        }
    }
}