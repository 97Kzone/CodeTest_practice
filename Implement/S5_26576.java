package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class S5_26576 {

    static Map<String, String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        init();

        int N = Integer.parseInt(br.readLine());
        String[] dates;
        int date;
        String sDate, sYear;
        for (int i = 0; i < N; i++) {
            dates = br.readLine().replace(",", "").split(" ");

            date = Integer.parseInt(dates[1]);
            if (!set.containsKey(dates[0])) {
                bw.write("Invalid" + "\n");
                continue;
            } else if (date < 1 || date > 31) {
                bw.write("Invalid" + "\n");
                continue;
            }

            sDate = date < 10 ? "0" + date : String.valueOf(date);
            sYear = dates[2].length() > 1 ? dates[2].substring(dates[2].length()- 2) : "0" + dates[2].charAt(0);
            bw.write(set.get(dates[0]) + "/" + sDate + "/" + sYear + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void init() {
        set = new HashMap<>();

        set.put("January", "01");
        set.put("February", "02");
        set.put("March", "03");
        set.put("April", "04");
        set.put("May", "05");
        set.put("June", "06");
        set.put("July", "07");
        set.put("August", "08");
        set.put("September", "09");
        set.put("October", "10");
        set.put("November", "11");
        set.put("December", "12");
    }
}

