from itertools import combinations as cb
N = int(input())
nums = []

#1자리부터 10자리(9876543210)까지 
for i in range(1, 11):
    for val in cb(range(0, 10), i):
        nums.append(int("".join(map(str, val[::-1]))))

nums.sort()
print(nums[N] if N < len(nums) else -1)