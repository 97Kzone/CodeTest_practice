import sys
from collections import defaultdict
input = sys.stdin.readline

N = int(input())
sub = defaultdict(list)
res = []

for i in range(N):
    r = list(map(int, input().split()))
    sub[i] = r[1:]

M = int(input())
for _ in range(M):
    st = list(map(int, input().split()))
    st = st[1:]

    cnt = 0
    for value in sub.values():
        l = len(value)

        for v in value:
            if v not in st:
                break
            l -= 1
        
        if l == 0:
            cnt += 1
    
    res.append(cnt)

for v in res:
    print(v)