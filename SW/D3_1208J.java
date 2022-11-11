// import java.util.*;

// public class D3_1208J {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
        
//         for (int t=1; t<11; t++) {
//             int N = sc.nextInt();
//             int[] nums = new int[100];
            
//             for (int i=0; i<100; i++) {
//                 int num = sc.nextInt();
//                 nums[i] = num;
//             }
//             Arrays.sort(nums);
//             for (int i=0; i<N; i++) {
//                 if (nums[99]-nums[0] == 0) break;

//                 nums[99] -= 1;
//                 nums[0] += 1;
//                 Arrays.sort(nums);
//             }
//             System.out.printf("#%d %d\n", t, nums[99]-nums[0]);
//         }    
//     }
// }

import java.util.*;

public class D3_1208J {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for (int t=1; t<11; t++) {
            int N = sc.nextInt();
            int[] nums = new int[101];
            
            int M = 0, n = 101, Mi, ni;
            for (int i=0; i<100; i++) {
                int num = sc.nextInt();
                nums[i] = num;
            }
            
            for (int i=0; i<N; i++) {
                int[] tmp = check(nums);
                M = tmp[0];
                n = tmp[1];
                Mi = tmp[2];
                ni = tmp[3];

                if (M - n == 0) break;
                
                nums[Mi] -= 1;
                nums[ni] += 1;
                
                }

            System.out.printf("#%d %d\n", t, M-n);
        }    
    }

    static int[] check(int[] arr) {
        int M = 0, n = 101;
        int Mi = 0, ni = 0;
        for (int i=0; i<100; i++) {
            if (M < arr[i]) {
                M = arr[i];
                Mi = i;
            }

            if (n > arr[i]) {
                n = arr[i];
                ni = i;
            }
        }
        int[] res = {M, n, Mi, ni};
        return res;
    }
}
