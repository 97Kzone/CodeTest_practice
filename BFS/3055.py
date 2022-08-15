import sys
from collections import deque
input = sys.stdin.readline

r, c = map(int, input().split())
board = [list(input().rstrip()) for _ in range(r)]
visit = [[0] * c for _ in range(r)]
moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def check(s, w):
    q1, q2 = deque(s), deque(w)
    while q1:
        #물이 먼저 갈 곳을 선점
        l = len(q2)
        for _ in range(l):
            i, j = q2.popleft()
            visit[i][j] = 1

            for dx, dy in moves:
                nx = i + dx
                ny = j + dy

                if 0 <= nx < r and 0 <= ny < c:
                    if board[nx][ny] == "." and visit[nx][ny] >= 0:
                        q2.append((nx, ny))
                        visit[nx][ny] = -1
            
        #이제 고슴도치가 움직일 차례
        l = len(q1)
        for _ in range(l):
            x, y, cnt = q1.popleft()
            visit[x][y] = 1
            
            for dx, dy in moves:
                nx = x + dx
                ny = y + dy

                if 0 <= nx < r and 0 <= ny < c:
                    if board[nx][ny] == "D":
                        return cnt+1

                    if board[nx][ny] == "." and visit[nx][ny] == 0:
                        q1.append((nx, ny, cnt+1))
                        visit[nx][ny] = 1

    return -1

w = []
for i in range(r):
    for j in range(c):
        if board[i][j] == "S":
            s = [(i, j, 0)]
        elif board[i][j] == "*":
            w.append((i, j))

res = check(s, w)
print(res if res != -1 else "KAKTUS")