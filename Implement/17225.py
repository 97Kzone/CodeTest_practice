import sys
from collections import deque
input = sys.stdin.readline

A, B, N = map(int, input().split())
s, j = deque(), deque()
se, je = 0, 0

for _ in range(N):
    a, b, c = input().split()
    a, c = int(a), int(c)
    
    if b == "B":
        a = max(a, se)    
        for i in range(c):
            s.append([a, 'B'])
            a += A
        se = a
    else:
        a = max(a, je)
        for i in range(c):
            j.append([a, 'R'])
            a += B
        je = a

total = s + j
total = sorted(total, key = lambda x : (x[0], x[1]))

r1, r2 = [], []
for i, v in enumerate(total):
    if v[1] == "B":
        r1.append(i+1)
    else:
        r2.append(i+1)
    
print(len(r1))
print(*r1)
print(len(r2))
print(*r2)