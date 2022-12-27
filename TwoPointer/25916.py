import sys
input = sys.stdin.readline

N, M = map(int, input().split())
nums = list(map(int, input().split()))

res = 0
i, j, t = 0, 1, 0

if N == 1:
    print(nums[0] if nums[0] <= M else 0)
    exit()

if nums[i] <= M:
    t += nums[i]

while i <= j and j < N:
    tmp = t + nums[j]
    if tmp <= M:
        t += nums[j]
        j += 1
    else:
        if nums[j] > M and j < N-1:
            i = j+1
            j += 1
            t = 0
        else:
            t -= nums[i]
            i += 1
    
    res = max(res, t)
        
print(res)