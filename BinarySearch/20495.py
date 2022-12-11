import sys
from bisect import bisect_left
input = sys.stdin.readline

N = int(input())
n1, n2 = [], []

for _ in range(N):
    a, b = map(int, input().split())
    n1.append(a-b)
    n2.append(a+b)

s1 = sorted(n1)
s2 = sorted(n2)

res = []
for i in range(N):
    l, r = 0 , N-1
    x, y = n1[i], n2[i]

    while l <= r:
        m = (l+r)//2
        if s2[m] >= x:
            r = m-1
        else:
            l = m+1
    
    tmp = l+1
    l, r = 0, N-1
    while l <= r:
        m = (l+r)//2
        if s1[m] <= y:
            l = m+1
        else:
            r = m-1
    
    tmp2 = r+1
    res.append((tmp, tmp2))

for v1, v2 in res:
    print(v1, v2)
 

print(res)