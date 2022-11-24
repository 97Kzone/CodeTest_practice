import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
seat = [deque([0]*20) for _ in range(N)]

res = set()
for _ in range(M):
    comm = list(map(int, input().split()))
    if len(comm) == 3:
        t, i, x = comm
        seat[i-1][x-1] = 1 if t == 1 else 0 
    else:
        t, i = comm
        if t == 3:
            seat[i-1].rotate(1)
            seat[i-1][0] = 0
        else:
            seat[i-1].rotate(-1)
            seat[i-1][-1] = 0

for r in seat:
    std = "".join(str(x) for x in r)
    res.add(std)

print(len(res))