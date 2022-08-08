from itertools import permutations as pm
import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))

res = 0
for val in pm(nums):
    s = 0
    for i in range(1, N):
        s += abs(val[i] - val[i-1])
    res = max(res, s)

print(res)