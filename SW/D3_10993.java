import java.util.*;

class city {
    int x, y, s, stat;

    public city(int a, int b, int c) {
        this.x = a;
        this.y = b;
        this.s = c;
        this.stat = -1;
    }
}
public class D3_10993 {
    static int N;
    static city[] c;
    static String res; 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
            N = sc.nextInt();
            c = new city[N];
            res = "";
            for (int i=0; i<N; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int s = sc.nextInt();

                c[i] = new city(x, y, s); 
            }
            
            //각 도시별 영향력 체크
            for (int i=0; i<N; i++) {
                int x1 = c[i].x;
                int y1 = c[i].y;
                int s1 = c[i].s;
                double me = Double.MIN_VALUE;

                for (int j=0; j<N; j++) {
                    if (i != j) {
                        double std = Math.pow((c[j].x-x1), 2) + Math.pow((c[j].y-y1), 2);
                        double e = c[j].s/std;

                        if (e > s1) {
                            if (e > me) {
                                c[i].stat = j;
                                me = e;
                            } else if (e == me) {
                                c[i].stat = -2;
                            }
                        }
                    }
                }
            }
            res += "#" + t + " ";
            for (int i=0; i<N; i++) {
                int v = c[i].stat;
                if (v == -1) {
                    res += "K ";
                } else if (v == -2) {
                    res += "D ";
                } else {
                    int tmp = check(i) + 1;
                    res += tmp + " ";
                }
            }
            System.out.println(res);
        }
    }

    static int check(int n) {
        if (c[n].stat == -1 || c[n].stat == -2) {
            return n;
        } else {
            c[n].stat = check(c[n].stat);
            return c[n].stat;
        }
    }
}    

