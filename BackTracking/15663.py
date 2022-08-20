import sys
from itertools import permutations as pm
input = sys.stdin.readline

N, M = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()

nums = set(pm(nums, M))
nums = sorted(nums)
for num in nums:
    print(*num)