import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer,Integer> timeMap = new HashMap<>();
        Map<Integer,Integer> totalTime = new HashMap<>();
        
        for(String record : records){
            String[] bits = record.split(" ");
            int min = timeToMinute(bits[0]);
            int carNo = Integer.parseInt(bits[1]);
            boolean in = bits[2].equals("IN");
            
            if(in){
                timeMap.put(carNo,min);
            } else {
                int parkedMin = min - timeMap.get(carNo);
                totalTime.put(carNo, totalTime.getOrDefault(carNo,0) + parkedMin);
                timeMap.remove(carNo);
            }
        }
        
        int lastTime = timeToMinute("23:59");
        for(int carNo : timeMap.keySet()){
            int parkedMin = lastTime - timeMap.get(carNo);
            totalTime.put(carNo, totalTime.getOrDefault(carNo,0) + parkedMin);
        }
        
        int[] answer = new int[totalTime.size()];
        int idx = 0;
        for(int keys : totalTime.keySet()){
            answer[idx++] = keys;
        }
        
        Arrays.sort(answer);
        for(int i = 0; i<answer.length; i++){
            int key = answer[i];
            answer[i] = getTotalFee(totalTime.get(key),fees);
        }
        
        
        return answer;
    }
    
    private int timeToMinute(String str){
        String[] bits = str.split(":");
        return (Integer.parseInt(bits[0]) * 60) + Integer.parseInt(bits[1]);
    }
    
    private int getTotalFee(int parkedMin , int[] fees){
        int totalFee = 0;
        if(parkedMin <= fees[0]){
            return fees[1];
        } else {
            totalFee = fees[1];
            int overTime = parkedMin - fees[0]; // 초과시간 산출
            totalFee += (fees[3]) * (overTime / fees[2]); // 초과 요금 처리
            if(overTime % fees[2] > 0) totalFee += fees[3]; // 올림 처리
            return totalFee;
        }
    }
}