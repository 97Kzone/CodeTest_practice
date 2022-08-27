import sys
input = sys.stdin.readline

H, W = map(int, input().split())
nums = list(map(int, input().split()))

res = 0
for i in range(1, W-1):
    l, r = max(nums[:i]), max(nums[i+1:])
    std = min(l, r)

    if nums[i] < std:
        res += std - nums[i]

print(res)
