import sys
input = sys.stdin.readline

N, M = map(int, input().split())
nums = list(map(int, input().split()))
res = sum(nums)
l, r = 0, 10**9

std = max(nums)
while l <= r:
    m = (l+r)//2

    if m < std:
        l = m+1
        continue

    cnt, tmp = 1, 0
    for i in range(N):
        if tmp + nums[i] <= m:
            tmp += nums[i]
        else:
            tmp = nums[i]
            cnt += 1
    
    if cnt <= M:
        r = m-1
        res = min(res, m)
    else:
        l = m+1

print(res)