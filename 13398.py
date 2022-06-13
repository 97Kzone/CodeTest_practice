N = int(input())
nums = list(map(int, input().split()))

dp = [[0, 0, 0] for _ in range(N)]
dp[0] = [nums[0], nums[0], 0]
res = 0

for i in range(1, N):
    dp[i][0] = nums[i]
    dp[i][1] = max(dp[i-1]) + nums[i]
    dp[i][2] = max(0, dp[i-1][2]) + nums[i-1]
    res = max(res, max(dp[i]))

if res == 0:
    print(max(nums))
else:
    print(res)