import sys
input = sys.stdin.readline

N, M, L = map(int, input().split())
nums = [int(input()) for _ in range(M)] + [L]

for _ in range(N):
    v = int(input())

    i, j = 1, 4000000
    res = 0
    while i <= j:
        m = (i+j) // 2

        idx, cnt = 0, 0
        for k in range(M+1):
            if nums[k]-idx >= m:
                cnt += 1
                idx = nums[k]
            
        if cnt > v:
            i = m+1
            res = max(res, m)
        else:
            j = m-1
    
    print(res)
