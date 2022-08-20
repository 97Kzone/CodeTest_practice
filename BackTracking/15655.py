import sys
from itertools import combinations as cb
input = sys.stdin.readline

N, M = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()

nums = list(cb(nums, M))
for num in nums:
    print(*num)