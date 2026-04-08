class Solution {
    public int solution(int m, int n, String[] board) {
        boolean[][] isDeleted = new boolean[m][n];
        int answer = 0;
        
        char[][] cBoard = new char[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                cBoard[i][j] = board[i].charAt(j);
            }
        }
        
        while(true){
            int deletedCnt = 0;
            
            // 4개 조건 충족하는 블록 스캔후 boolean 2차원 배열에 반영
            for(int i = 0; i< m-1; i++){
                for(int j = 0; j <n-1; j++){
                    char t = cBoard[i][j];
                    if(
                        cBoard[i][j] != '.'   &&
                        cBoard[i+1][j] == t   &&
                        cBoard[i][j+1] == t   &&
                        cBoard[i+1][j+1] == t 
                    ){
                        isDeleted[i][j] = true;
                        isDeleted[i+1][j] = true;
                        isDeleted[i][j+1] = true;
                        isDeleted[i+1][j+1] = true;
                    }
                }
            }
            
            // boolean 배열에 따라 board 배열 글자 변경 및 글자 수 세기
            for(int i = 0; i<m; i++){
                for(int j = 0; j<n; j++){
                    if(isDeleted[i][j]){
                        deletedCnt ++;
                        cBoard[i][j] = '.';
                    }
                }
            }
            
            // 지워진 블록으로 인해 위에 있는 블록 내리기
            for(int line = 0; line<n; line++){
                for(int j = m -1; j>= 0; j--){
                    if(cBoard[j][line] == '.'){
                        for(int k = j -1; k>=0; k--){
                            if(cBoard[k][line] != '.'){
                                cBoard[j][line] = cBoard[k][line];
                                cBoard[k][line] = '.';
                                break;
                            }
                        }
                    }
                }
            }
            
            
            // 지워진 블록이 없으면 break, 아니면 지워진 블록 개수 누산 후 isDeleted 초기화
            if(deletedCnt == 0) break;
            answer += deletedCnt;
            isDeleted = new boolean[m][n];
        }
        
        return answer;
    }
    
}