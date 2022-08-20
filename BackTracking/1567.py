import sys
from itertools import combinations_with_replacement as cr
input = sys.stdin.readline

N, M = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()

nums = list(cr(nums, M))
for num in nums:
    print(*num)