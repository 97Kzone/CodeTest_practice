import sys
from itertools import accumulate as ac
input = sys.stdin.readline

N = int(input())
nums = [int(input()) for _ in range(N)]
nums += nums
s = list(ac(nums))

res = 0
for i in range(N, 2*N):
    for j in range(i-N+1, N):
        res = max(res, min(s[i]-s[j], s[j+N]-s[i]))

print(res)