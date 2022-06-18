import sys
input = sys.stdin.readline

s1 = input().strip()
s2 = input().strip()

dp = [[0] * len(s1) for _ in range(len(s2))]
res = 0

for i in range(len(s2)):
    for j in range(len(s1)):
        if s2[i] == s1[j]:
            if i == 0 or j == 0:
                dp[i][j] = 1
            else:
                dp[i][j] = dp[i-1][j-1] + 1
            res = max(res, dp[i][j])

print(res)