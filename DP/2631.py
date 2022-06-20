import sys
input = sys.stdin.readline

N = int(input())
nums = [int(input()) for _ in range(N)]

dp = [1 for _ in range(N)]

for i in range(N):
    for j in range(i):
        if nums[i] > nums[j]:
            dp[i] = max(dp[i], dp[j]+1)

print(dp)