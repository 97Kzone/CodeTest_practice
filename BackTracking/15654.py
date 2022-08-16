#Python style
import sys
from itertools import permutations as pm 
input = sys.stdin.readline

N, M = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()

res = list(pm(nums, M))

for v in res:
    print(" ".join(str(i) for i in v))