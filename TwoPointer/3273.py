import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))
nums.sort()
M = int(input())

i, j = 0, N-1
res = 0
while i < j:
    s = nums[i] + nums[j]
    if s == M:
        res += 1
        i += 1
    elif s < M:
        i += 1
    else:
        j -= 1

print(res)