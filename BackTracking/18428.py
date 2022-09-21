from copy import deepcopy
import sys
from itertools import permutations as pm
input = sys.stdin.readline

N = int(input())
board, walls, t = [], [], []

def check(std, wall):
    #벽 세우기
    for i, j in wall:
        std[i][j] = "O"
    
    for i, j in t:
        #위로 검사
        for x in range(i, -1, -1):
            if std[x][j] == "S":
                return
            elif std[x][j] == "O":
                break
            
        #아래로 검사
        for x in range(i, N):
            if std[x][j] == "S":
                return
            elif std[x][j] == "O":
                break
            
        #왼쪽으로 검사
        for y in range(j, -1, -1):
            if std[i][y] == "S":
                return 
            elif std[i][y] == "O":
                break
            
        #오른쪽으로 검사
        for y in range(j, N):
            if std[i][y] == "S":
                return 
            elif std[i][y] == "O":
                break
    
    print("YES")
    exit()

for i in range(N):
    row = list(input().split())
    for j, r in enumerate(row):
        if r == "X":
            walls.append((i, j))
        elif r == "T":
            t.append((i, j))
    board.append(row)

flag = False
for v in pm(walls, 3):
    tmp = deepcopy(board)
    check(tmp, v)

print("NO")
    