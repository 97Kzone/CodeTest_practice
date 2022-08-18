import sys
from itertools import accumulate as ac
input = sys.stdin.readline

N, K, B = map(int, input().split())
nums = [0] * N

for _ in range(B):
    nums[int(input())-1] = 1

cnt = list(ac(nums))
res = B
for i in range(N-K):
    res = min(res, cnt[i+K]-cnt[i])

print(res)