import sys
input = sys.stdin.readline

N, M = map(int, input().split())
nums = list(map(int, input().split()))

def check(m):
    i, j, cnt = 0, 1, 0
    while i+j <= N:
        if max(nums[i:i+j]) - min(nums[i:i+j]) <= m:
            j += 1
        else:
            i += j-1
            j = 1
            cnt += 1

    return cnt

res = 0
if M == 1:
    print(max(nums) - min(nums))
    exit()
else:
    l, r = 0, max(nums)
    while l <= r:
        m = (l+r) // 2
        if check(m) >= M:
            l = m+1
        else:
            r = m-1
            res = m
    
print(res)