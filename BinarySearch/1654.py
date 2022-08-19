import sys
input = sys.stdin.readline

K, N = map(int, input().split())
std = [int(input()) for _ in range(K)]

i, j = 1, sum(std) // N
res = 0
while i <= j:
    m = (i+j) // 2
    
    s = 0
    for v in std:
        s += v // m
    
    if s >= N:
        res = max(res, m)
        i = m + 1
    else:
        j = m - 1

print(res)