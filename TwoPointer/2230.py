import sys
input = sys.stdin.readline

N, M = map(int, input().split())
nums = [int(input()) for _ in range(N)]
nums.sort()

i, j = 0, 1
res = 10e9
while j < N and i <= j:
    if nums[j] - nums[i] >= M:
        res = min(res, nums[j]-nums[i])
        i += 1
    else:
        j += 1

print(res)