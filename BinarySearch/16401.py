import sys
input = sys.stdin.readline

M, N = map(int, input().split())
cookies = list(map(int, input().split()))

l, r = 0, 1000000000
res = 0
while l <= r:
    m = (l+r) // 2
    if m == 0:
        break

    cnt = 0
    for cookie in cookies:
        if cookie >= m:
            cnt += (cookie // m)
    
    if cnt >= M:
        res = m
        l = m+1
    else:
        r = m-1

print(res)
