import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tmp = "";
        for (int t = 1; t <= 10; t++) {
            tmp = br.readLine();

            String tar = br.readLine();
            String std = br.readLine();

            int res = 0;
            int l = 0;
            while (true) {
                l = std.length();
                std = std.replaceFirst(tar, "");
                if (std.length() == l) {
                    break;
                }
                res++;
            }
            System.out.printf("#%d %d\n", t, res);
        }
    }
}
