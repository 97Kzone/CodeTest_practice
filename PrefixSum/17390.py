import sys
from itertools import accumulate
input = sys.stdin.readline

N, Q = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()
nums = [0] + list(accumulate(nums))

for _ in range(Q):
    s, e = map(int, input().split())
    print(nums[e] - nums[s-1])