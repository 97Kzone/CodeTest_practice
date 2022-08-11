import sys
input = sys.stdin.readline

N, M, K = map(int, input().split())
beers = [list(map(int, input().split())) for _ in range(K)]
beers.sort(key = lambda x : -x[0])

l, r = 0, 2200000000
res = 10e9

while l <= r:
    m = (l+r) // 2
    s, cnt = 0, 0

    for a, b in beers:
        if cnt == N:
            break
        
        if b <= m: 
            s += a
            cnt += 1

    if cnt == N and s >= M:
        res = min(res, m)
        r = m-1
    else:
        l = m+1

print(res if res != 10e9 else -1)
        