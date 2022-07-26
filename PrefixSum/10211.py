from cmath import inf
import sys
from itertools import accumulate
input = sys.stdin.readline

for _ in range(int(input())):
    N = int(input())
    nums = list(map(int, input().split()))
    nums = [0] + list(accumulate(nums))

    res = -inf
    for i in range(1, N+1):
        for j in range(i):
            res = max(res, nums[i] - nums[j])
    
    print(res)
