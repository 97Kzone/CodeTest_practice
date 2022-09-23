import sys
from itertools import product as pd
input = sys.stdin.readline

N, M = map(int, input().split())
b = [True, False]
board = [list(map(int, input().split())) for _ in range(M)]

for v in pd(b, repeat=N):
    for n1, n2 in board:
        a, b = v[abs(n1)-1], v[abs(n2)-1]

        if n1 < 0:
            a = not a
        
        if n2 < 0:
            b = not b
        
        if not (a or b):
            break
    else:
        print(1)
        exit()

print(0)

        



