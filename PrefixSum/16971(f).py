from cmath import inf
import sys
from itertools import accumulate as ac
input = sys.stdin.readline

N, M = map(int, input().split())
nums = [list(map(int, input().split())) for _ in range(N)]

sum_r = []
for num in nums:
    sum_r.append(list(ac(num)))

sum_c = []
for num in zip(*nums):
    sum_c.append(list(ac(num)))

#행을 먼저 검사
Mx = max(sum_r[0][-1], sum_r[-1][-1])
mx = inf
for i in range(1, N-1):
    mx = min(mx, sum_r[i])

#열도 검사
My = max(sum_c[0][-1], sum_c[-1][-1])


    