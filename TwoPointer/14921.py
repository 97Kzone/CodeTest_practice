import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))

i, j = 0, N-1
res = 10**9
while i < j and j < N:
    tmp = nums[i] + nums[j]
    if abs(tmp) < abs(res):
        res = tmp
    if tmp < 0:
        i += 1
    else:
        j -= 1

print(res)