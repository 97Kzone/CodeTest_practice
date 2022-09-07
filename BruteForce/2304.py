import sys
input = sys.stdin.readline

N = int(input())
nums = [list(map(int, input().split())) for _ in range(N)]
nums.sort(key = lambda x : x[0])
x, y = sorted(nums, key = lambda x : x[1])[-1]

h = [0] * (nums[-1][0] + 1)
for i, j in nums:
    h[i] = j

res, std = 0, 0
for i in range(x+1):
    if h[i] > std:
        std = h[i]
    res += std

std = 0
for i in range(nums[-1][0], x, -1):
    if h[i] > std:
        std = h[i]
    res += std

print(res)