import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))

for i in range(1, N):
    nums[i] += nums[i-1]

res = 0
for i in range(1, N-1):
    #case1 BBP
    v1 = (nums[-1]-nums[i]) * 2 + nums[i-1]-nums[0]
    #case2 BPB
    v2 = (nums[i]-nums[0]) + (nums[-2] - nums[i]) if N != 3 else nums[i] * 2
    #case3 PBB
    v3 = nums[i-1] * 2 + (nums[-2] - nums[i])

    res = max(res, v1, v2, v3)

print(res)