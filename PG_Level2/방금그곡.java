package PG_Level2;

import java.util.*;

class Solution {
    static Map<String, String> songs;
    
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        songs = new LinkedHashMap<>();
        
        m = change(m);
        
        int time, div, mod;
        String song;
        for (String infos : musicinfos) {
            String[] info = infos.split(",");
            time = str2min(info[0], info[1]);
            
            info[3] = change(info[3]);
            div = time / info[3].length();
            mod = time % info[3].length();
            
            song = info[3].repeat(div) + info[3].substring(0, mod);
            songs.put(song, info[2]);
        } 
        
        for (String key : songs.keySet()) {
            if (key.contains(m)) {
                if (answer.length() < key.length()) answer = key;
            }
        }
        if ("".equals(answer)) return "(None)";
        
        return songs.get(answer);
    }
    
    static int str2min(String t1, String t2) {
        int t;
        
        String[] h1 = t1.split(":");
        String[] h2 = t2.split(":");
        t = (Integer.parseInt(h2[0]) * 60 + Integer.parseInt(h2[1])) - 
            (Integer.parseInt(h1[0]) * 60 + Integer.parseInt(h1[1]));
        
        return t;
    }
    
    static String change(String s) {
        return s.replace("C#", "H")
                .replace("D#", "I")
                .replace("F#", "J")
                .replace("G#", "K")
                .replace("A#", "L");
    }
}