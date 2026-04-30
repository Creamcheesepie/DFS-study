class Solution {
    public String solution(String m, String[] musicinfos) {
        String[] answer = new String[] {"","-1"};
        String tSimpleNotes = getSimpleNotes(m);
        
        for(String music : musicinfos){
            String[] bits = music.split(",");
            int st = timeToMinutes(bits[0]);
            int et = timeToMinutes(bits[1]);
            String title = bits[2];
            String notes = getSimpleNotes(bits[3]);
            int length = notes.length();
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i< et-st; i++){
                sb.append(notes.charAt(i % length));
            }
            String fullNotes = sb.toString();
            if(fullNotes.contains(tSimpleNotes) && Integer.parseInt(answer[1]) < et - st){
                answer = new String[] {title,(et - st)+ ""};
            }
        }
            
        if(answer[0].isBlank()) return "(None)";
        return answer[0];
    }
    
    private int timeToMinutes(String time){
        String[] bits = time.split(":");
        int hour = Integer.parseInt(bits[0]);
        int min = Integer.parseInt(bits[1]);
        return (hour * 60) + min;
    }
    
    // #을 소문자로 변경
    private String getSimpleNotes(String notes){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<notes.length(); i++){
            char note = notes.charAt(i);
            if(i + 1 < notes.length() && notes.charAt(i+1) == '#'){
                note = Character.toLowerCase(note);
                i++;
            }
            sb.append(note);
        }
        return sb.toString();
    }
}