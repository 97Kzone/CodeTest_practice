import java.util.Scanner;

public class D2_2005 {
   public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();

    for (int t=1; t<=T; t++) {
        int N = sc.nextInt();

        int[][] nums = new int[N][];
        nums[0] = new int[] {1};
        
        for (int i=1; i<N; i++) {
            nums[i] = new int[i+1];
            
            for (int j=0; j<nums[i].length; j++) {
                if (j == 0 || j == nums[i].length-1) {
                    nums[i][j] = 1;
                } else {
                    nums[i][j] = nums[i-1][j] + nums[i-1][j-1];
                }
            }
        }
        System.out.printf("#%d\n", t);
        for (int i=0; i<N; i++) {
            String res = "";
            for (int j=0; j<nums[i].length; j++) {
                res += nums[i][j] + " ";
            }
            System.out.printf("%s\n", res); 
        }
    }
    sc.close();
   } 
}
