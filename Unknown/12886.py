from collections import deque
from itertools import combinations as cb

A, B, C = sorted(map(int, input().split()))
total = A + B + C
check = set()
check.add((A, B, C))

q = deque()
q.append([A, B, C])

while q:
    a, b, c = q.popleft()
    if a == b and b == c:
        print(1)
        break
    
    for x, y in cb([a, b, c], 2):
        if y >= x :
            y -= x
            x *= 2
            z  = total - x - y
            x, y, z = sorted([x, y, z])
            if not (x, y, z) in check:
                check.add((x, y, z))
                q.append([x, y, z])
else:
    print(0)