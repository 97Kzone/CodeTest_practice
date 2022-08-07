import sys
input = sys.stdin.readline

N, M = map(int, input().split())
nums = list(map(int, input().split()))

i, j = 0, 1
res = 0

while j <= N and i <= j:
    s = sum(nums[i:j])
    if s == M:
        res += 1
        j += 1
    elif s > M:
        i += 1
    else:
        j += 1

print(res)
