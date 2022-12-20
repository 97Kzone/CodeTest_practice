import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))
dp = [10**9] * N
dp[0] = 0

for i in range(1, N):
    for j in range(0, i):
        tmp = max((i-j) * (1 + abs(nums[i]-nums[j])), dp[j])
        dp[i] = min(dp[i], tmp)

print(dp[-1])