import sys
from copy import deepcopy
from itertools import permutations as pm
input = sys.stdin.readline

n, m, k = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
moves = [list(map(int, input().split())) for _ in range(k)]
moves = list(pm(moves, k))

def rotate(b, comm):
    r, c, s = comm
    r -= 1
    c -= 1
    
    for i in range(s, 0, -1):
        tmp = b[r-i][c+i]
        
        #위
        b[r-i][c-i+1:c+i+1] = b[r-i][c-i:c+i]

        #왼쪽
        for j in range(r-i, r+i):
            b[j][c-i] = b[j+1][c-i]
        
        #아래
        b[r+i][c-i:c+i] = b[r+i][c-i+1:c+i+1]

        #오른쪽
        for j in range(r+i, r-i, -1):
            b[j][c+i] = b[j-1][c+i]
        
        b[r-i+1][c+i] = tmp

    return b

res = 10**9
for move in moves:
    tmp = deepcopy(board)
    for comm in move:
        tmp = rotate(tmp, comm)
    
    for row in tmp:
        res = min(res, sum(row))

print(res)