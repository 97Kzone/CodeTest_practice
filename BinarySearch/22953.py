import sys
input = sys.stdin.readline

N, K, C = map(int, input().split())
nums = list(map(int, input().split()))
std = sum(nums)-N

def check(k, v):
    if v == C or v >= std:
        l, r = 0, 10**12
        
        while l+1 < r:
            m = (l+r) // 2
            cnt = 0

            for num in nums:
                cnt += m // num
            
            if cnt >= K:
                r = m
            else:
                l = m
        return r

    res = 10**12
    for i in range(k, N):
        if nums[i] == 1:
            continue

        nums[i] -= 1
        res = min(res, check(i, k+1))
        nums[i] += 1
    
    return res

print(check(0, 0))