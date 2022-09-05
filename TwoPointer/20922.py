import sys
from collections import defaultdict
input = sys.stdin.readline

N, K = map(int, input().split())
nums = list(map(int, input().split()))
d = defaultdict(int)

res, i, j = 0, 0, 1
d[nums[i]] = 1

while j < N:
    if d[nums[j]] < K:
        d[nums[j]] += 1
        j += 1
    else:
        d[nums[i]] -= 1
        i += 1
    res = max(res, j-i)

print(res)