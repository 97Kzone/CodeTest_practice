import sys
input = sys.stdin.readline

N, M = map(int, input().split())
times = list(map(int, input().split()))

i, j = 0, M*max(times)
res = 0
while i <= j:
    m = (i+j)//2
    tmp = 0
    for v in times:
        tmp += m//v
    
    if tmp >= M:
        res = m
        j = m-1
    else:
        i = m+1

print(res)
