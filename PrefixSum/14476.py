from itertools import accumulate
import math
import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))

pre = list(accumulate(nums, math.gcd))
pre_r = list(accumulate(nums[::-1], math.gcd))
pre_r.sort()

pre = pre + [0]
pre_r = pre_r + [0]

res = []
for i in range(N):
    t = math.gcd(pre[i-1], pre_r[i+1])
    if nums[i] % t == 0:
        continue
    res.append((t, nums[i]))

res.sort(reverse=True)
print(" ".join(str(v) for v in res[0]) if res else -1)