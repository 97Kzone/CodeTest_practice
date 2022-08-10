import sys
input = sys.stdin.readline

D, N, M = map(int, input().split())
rocks = [int(input()) for _ in range(N)] + [D]
rocks.sort()

l, r = 0, D
res = 0
while l <= r:
    m = (l+r) // 2
    idx, cnt = 0, 0

    for rock in rocks:
        if rock - idx < m:
            cnt += 1
        else:
            idx = rock
        
    if cnt <= M:
        l = m + 1
        res = m
    else:
        r = m - 1

print(res)
    

