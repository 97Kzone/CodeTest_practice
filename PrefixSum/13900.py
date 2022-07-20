from itertools import accumulate

N = int(input())
nums = list(map(int, input().split()))
sum = list(accumulate(nums))

res = 0
for i in range(N):
    res += nums[i] * (sum[-1] - sum[i])

print(res)