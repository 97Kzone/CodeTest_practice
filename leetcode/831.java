package leetcode;

class Solution {
    public String maskPII(String s) {

        String res = "";
        // email
        if (s.contains("@")) {
            s = s.toLowerCase();
            String[] tmp = s.split("@");

            res = tmp[0].charAt(0) + "*****" + tmp[0].charAt(tmp[0].length() - 1);
            res += "@" + tmp[1];
        } else {
            s = s.replaceAll("\\+", "");
            s = s.replaceAll("\\-", "");
            s = s.replaceAll("\\(", "");
            s = s.replaceAll("\\)", "");
            s = s.replaceAll(" ", "");

            if (s.length() == 10) res = "***-***-" + s.substring(6, 10);
            else if (s.length() == 11) res = "+*-***-***-" + s.substring(7, 11);
            else if (s.length() == 12) res = "+**-***-***-" + s.substring(8, 12);
            else res = "+***-***-***-" + s.substring(9, 13);
        }

        return res;
    }
}
