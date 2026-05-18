import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int picksCnt = 0;
        for(int p : picks) picksCnt += p;
        int fivesLen = Math.min((minerals.length + 4) / 5 ,picksCnt); 
        int[][] fives = new int[fivesLen][4];

        for(int i = 0; i< fivesLen*5 && i<minerals.length; i++){
            String mineral = minerals[i];
            int fIndex = i / 5;
            if(fIndex > picksCnt) break;
            if(mineral.charAt(0) == 'd') {
                fives[fIndex][1] += 1;
                fives[fIndex][0] += 25;
            }
            if(mineral.charAt(0) == 'i') {
                fives[fIndex][2] += 1;
                fives[fIndex][0] += 5;
            }
            if(mineral.charAt(0) == 's') {
                fives[fIndex][3] += 1;
                fives[fIndex][0] += 1;
            }
        }
        
        Arrays.sort(fives,
                   (f1, f2) -> f2[0] - f1[0]
                   );
        
        for(int[] f : fives){
            if(picks[0] > 0){
                picks[0] -= 1;
                answer += f[3] + f[2] + f[1]; 
            } else if(picks[1] > 0) {
                picks[1] -= 1;
                answer += f[3] + f[2] + (f[1] * 5); 
            } else if(picks[2] > 0){
                picks[2] -= 1;
                answer += f[3] + (f[2]*5) + (f[1] * 25); 
            } else {
                break;
            }
        }
        
        return answer;
    }
    
}