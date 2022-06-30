import sys
input = sys.stdin.readline

dp = [[0] * 10 for _ in range(65)]
dp[1] = [1 for _ in range(10)]

for i in range(2, 65):
    for j in range(10):
        dp[i][j] = sum(dp[i-1][j:])


for _ in range(int(input())):
    print(sum(dp[int(input())]))
