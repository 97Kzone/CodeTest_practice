import sys
input = sys.stdin.readline

N, M = map(int, input().split())
trees = list(map(int, input().split()))

i, j = 0, max(trees)
res = 0
while i <= j:
    m = (i+j) // 2
    s = 0

    for t in trees:
        if t - m > 0:
            s += t-m
    
    if s >= M:
        res = max(res, m)
        i = m + 1
    else:
        j = m - 1

print(res)
    
