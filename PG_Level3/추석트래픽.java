import java.util.*;

/*
 * 접근법
 * 1. 익숙한 패턴 BUT 1000분의 1초까지 고려한다
 * 2. 범위 설명이 굉장히 비문학 지문이다 잘 읽어보자
 * 3. 2번을 읽고 저처럼 헤매지 마세요.
 */
public class 추석트래픽 {
    static List<int[]> time = new ArrayList<>();
    static int answer;
    
    public int solution(String[] lines) {
        time.clear();
        int size = lines.length;
        
        // 길이가 1이면 따질게 없다
        if (size == 1) return 1;
        
        String[] tmp;
        for (String line : lines) {
            tmp = line.split(" ");
            time.add(str2sec(tmp[1], tmp[2]));
        }
        
        answer = 0;
        int cnt;
        
        for (int i = 0; i < size; i++) {
            int std = time.get(i)[1] + 999;
            cnt = 1;
            
            for (int j = i + 1; j < size; j++) {
                int check = time.get(j)[0];
                if (std >= check) cnt++;
            }
            if (cnt > answer) answer = cnt;
        }
        
        return answer;
    }
    
    public int[] str2sec(String s1, String s2) {
        String[] std = s1.split(":");
        int h = Integer.parseInt(std[0]) * 3600 * 1000;
        int m = Integer.parseInt(std[1]) * 60 * 1000;
        int s = (int) (Double.parseDouble(std[2]) * 1000);
        
        int v = (int) (Double.parseDouble(s2.substring(0, s2.length() - 1)) * 1000);
        
        return new int[] {h+m+s-v+1, h+m+s};
    }
}
