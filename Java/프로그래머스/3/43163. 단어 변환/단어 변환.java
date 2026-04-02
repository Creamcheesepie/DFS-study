import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        // 가장 짧은 < BFS
        Deque<Node> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        
        queue.offer(new Node(begin,0));
        
        while(!queue.isEmpty()){
            Node current = queue.poll();
            String word = current.word;
            int level = current.level;
            if(word.equals(target)) return level;
            
            Set<Character> set = new HashSet<>();
            for(int i = 0; i<word.length(); i++){
                set.add(word.charAt(i));
            }
            
            for(int i = 0; i<words.length; i++){
                String nextWord = words[i];
                if(isOneChange(word,nextWord) && !visited[i]){
                    queue.offer(new Node(nextWord,level + 1));
                    visited[i] = true;
                }
                
            }
            
        }
        
        
        return 0;
    }
    
    private class Node{
        String word;
        int level;
        
        public Node(String word, int level){
            this.word = word;
            this.level = level;
        }
    }
    
    private boolean isOneChange(String str1, String str2){
        int match = 0;
        int n = str1.length();
        for(int i = 0; i<n; i++){
            if(str1.charAt(i) == str2.charAt(i)) match++;
        }
        return match == n - 1;
    }
}