package leetcode;

import java.math.BigDecimal;

class Solution {
    public String multiply(String num1, String num2) {
        BigDecimal n1 = new BigDecimal(num1);
        BigDecimal n2 = new BigDecimal(num2);

        return n1.multiply(n2).toString();
    }
}
