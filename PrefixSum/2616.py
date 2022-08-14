import sys
from itertools import accumulate
input = sys.stdin.readline

N = int(input())
carts = list(map(int, input().split()))
M = int(input())

s = [0] + list(accumulate(carts))
dp = [[0] * (N+1) for _ in range(4)]

for i in range(1, 4):
    for j in range(i*M, N+1):
        if i == 1:
            dp[i][j] = max(dp[i][j-1], s[j]-s[j-M])
        else:
            dp[i][j] = max(dp[i][j-1], dp[i-1][j-M] + s[j] - s[j-M])

print(max(dp[-1]))