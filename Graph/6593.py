import sys
from collections import deque

input = sys.stdin.readline

moves = [(0, 0, 1), (0, 0, -1), (0, 1, 0), (0, -1, 0), (1, 0, 0), (-1, 0, 0)]
answer = []
def check(x, y, z, t):
    q = deque()
    q.append((x, y, z, t))
    visit = [[[0] * C for _ in range(R)] for _ in range(L)]
    visit[x][y][z] = 1

    while q:
        x, y, z , t = q.popleft()
        
        if board[x][y][z] == "E":
            return t
        
        for dx, dy, dz in moves:
            nx = x + dx
            ny = y + dy
            nz = z + dz

            if 0 <= nx < L and 0 <= ny < R and 0 <= nz < C:
                if visit[nx][ny][nz] == 0:
                    if board[nx][ny][nz] == "#":
                        continue
                    else:
                        q.append((nx, ny, nz, t+1))
                        visit[nx][ny][nz] = 1

    return -1

while True:
    L, R, C = map(int, input().split())
    if L == R == C == 0:
        break
    
    board = []
    for _ in range(L):
        t = []
        while True:
            v = list(input().rstrip("\n"))
            if v:
                t.append(v)
            else:
                break
        board.append(t)
    
    for i in range(L):
        for j in range(R):
            for k in range(C):
                if board[i][j][k] == "S":
                    s = (i, j, k)

    res = check(s[0], s[1], s[2], 0)                
    answer.append("Escaped in " + str(res) + " minute(s)." if res != -1 else "Trapped!")

for ans in answer:
    print(ans)