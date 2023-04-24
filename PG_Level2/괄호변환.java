package PG_Level2;

public class 괄호변환 {
    public String solution(String p) {
        if ("".equals(p)) return "";
        
        String answer = sol(p);
        return answer;
    }
    
    static String sol(String s) {        
        if ("".equals(s)) return "";
        
        int cnt = 0;
        String u = "";
        String v = "";
        // 균형잡힌 문자열 추출 (더 이상 분리할 수 없다 = 최소)
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') cnt++;
            else cnt--;
            
            // 최소로 같아지는 순간
            if (cnt == 0) {
                u = s.substring(0, i+1);
                v = s.substring(i+1, s.length());
                break;
            }
        }
        
        if (check(u)) return u + sol(v);
        
        String res = "";
        u = u.substring(1, u.length() - 1); 

        res = "(" + sol(v) + ")";  
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') res += ")";
            else res += "(";
        }  
        
        return res; 
    }
    
    // 올바른 괄호 문자열의 최소조건
    static boolean check(String s) {
        if (s.charAt(0) == '(') return true;
        else return false;
    }
}
