package leetcode;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    static int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], -1);
        }

        int x = 0;
        int y = 0;
        int d = 0;

        int nx, ny;
        while(head != null) {
            res[x][y] = head.val;
            head = head.next;

            nx = x + moves[d][0];
            ny = y + moves[d][1];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n || res[nx][ny] != -1) {
                d = (d + 1) % 4;
                nx = x + moves[d][0];
                ny = y + moves[d][1];
            }

            x = nx;
            y = ny;
        }

        return res;
    }
}