import sys
from collections import deque
input = sys.stdin.readline

def BFS(s, f):
    q1, q2 = deque(s), deque(f)

    while q1:
        #불이 먼저 퍼진다
        l = len(q2)
        for _ in range(l):
            x, y = q2.popleft()
            
            for dx, dy in moves:
                nx = x + dx
                ny = y + dy

                if 0 <= nx < r and 0 <= ny < c:
                    if board[nx][ny] == "." and visit[nx][ny] >= 0:
                        q2.append((nx, ny))
                        visit[nx][ny] = -1
    
        l = len(q1)
        for _ in range(l):
            x, y, cnt = q1.popleft()

            if x == 0 or x == r-1 or y == 0 or y == c-1:
                return cnt

            for dx, dy in moves:
                nx = x + dx
                ny = y + dy

                if 0 <= nx < r and 0 <= ny < c:
                    if board[nx][ny] == "." and visit[nx][ny] == 0:
                        q1.append((nx, ny, cnt+1))
                        visit[nx][ny] = 1
    
    return -1

for _ in range(int(input())):
    c, r = map(int, input().split())
    board = [list(input().rstrip()) for _ in range(r)]
    visit = [[0] * c for _ in range(r)]
    moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    
    fire = []
    for i in range(r):
        for j in range(c):
            if board[i][j] == "@":
                start = [(i, j, 0)]
            elif board[i][j] == "*":
                fire.append((i, j))
    
    res = BFS(start, fire)
    print(res+1 if res != -1 else "IMPOSSIBLE")    