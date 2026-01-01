package leetcode;

import java.util.*;

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int n1 = players.length;
        int n2 = trainers.length;

        int res = 0;
        int idx1 = 0, idx2= 0;
        while(true) {
            if (idx1 == n1 || idx2 == n2) break;

            if (players[idx1] <= trainers[idx2]) {
                idx1++;
                idx2++;
                res++;
            } else {
                idx2++;
            }
        }

        return res;
    }
}