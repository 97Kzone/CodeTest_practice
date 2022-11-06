import java.util.*;

public class D3_15612J {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int t=1; t <= T; t++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> col = new ArrayList<>();
            String res = "yes";

            for (int i=0; i<8; i++) {
                String r = sc.nextLine();
                for (int j=0; j<8; j++) {
                    char c = r.charAt(j);
                    if (c == 'O'){
                        row.add(i);
                        col.add(j);
                    }
                }
            }

            if (row.size() != 8) {
                res = "no";
            } else {
                for (int i=0; i<8; i++) {
                    if (row.contains(i) && col.contains(i)) {
                        continue;
                    } else {
                        res = "no";
                        break;
                    }
                }
            }
            System.out.printf("#%d %s\n", t, res);
        }    
        sc.close();
    }    
}
