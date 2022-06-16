import sys

N = int(input())
nums = {}

for _ in range(N):
    num = int(input())
    if num in nums:
        nums[num] += 1
    else:
        nums[num] = 1

res = sorted(nums.items())

for key, value in res:
    while value:
        print(key)
        value -= 1
