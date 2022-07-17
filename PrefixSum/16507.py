import sys
from itertools import accumulate
input = sys.stdin.readline

R, C, Q = map(int, input().split())

nums = [[0] + list(map(int, input().split())) for _ in range(R)]
nums.insert(0, [0] * (C+1))

#행 전부다 더하기
for i, num in enumerate(nums):
    nums[i] = list(accumulate(num))

#행 열 뒤집고
nums = list(map(list, zip(*nums)))

#다시 다 더하기
for i, num in enumerate(nums):
    nums[i] = list(accumulate(num))

#행 열 다시 뒤집고
nums = list(map(list, zip(*nums)))

for _ in range(Q):
    r1, c1, r2, c2 = map(int, input().split())
    v = (r2 - r1 + 1) * (c2- c1 + 1)
    
    print((nums[r2][c2] - nums[r1-1][c2] - nums[r2][c1-1] + nums[r1-1][c1-1]) // v)
