import sys
import bisect
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))

dp = []
for num in nums:
    if num >= 0:
        idx = bisect.bisect_left(dp, num)

        if len(dp) <= idx:
            dp.append(num)
        else:
            dp[idx] = num
    else:
        idx = bisect.bisect_right(dp, num)

        if len(dp) >= idx:
            dp.append
print(len(dp))
print(dp)