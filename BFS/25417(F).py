import sys
from collections import deque
input = sys.stdin.readline

board = [list(map(int, input().split())) for _ in range(5)]
r, c = map(int, input().split())
moves = [(1, 0), (-1, 0), (0, -1), (0, 1)]
visit = [[0] * 5 for _ in range(5)]

def BFS(x, y):
    q = deque()
    q.append((x, y, 0))
    
    while q:
        print(q)
        x, y, cnt = q.popleft()

        if board[x][y] == 1:
            return cnt

        #일단 한칸씩 이동
        for dx, dy in moves:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < 5 and 0 <= ny < 5:
                if board[nx][ny] == -1:
                    continue

                if visit[nx][ny] == 0:
                    q.append((nx, ny, cnt+1))
                    visit[nx][ny] = 1
        
        #이제 4방향 점프를 해보자
        for i in range(2, 5):
            if 0 <= x-i:
                if visit[x-i][y] == 0:
                    if board[x-i][y] == 7:
                        q.append((x-i, y, cnt+1))
                        visit[x-i][y] = 1
                    elif board[x-i][y] == -1:
                        q.append((x-i+1, y, cnt+1))
                        visit[x-i+1][y] = 1
                        continue

                    if x-i == 0 and board[x-i] == 0:
                        q.append(0, y, cnt+1)
                        visit[0][y] = 1
 
            if x+i < 5:
                if visit[x+i][y] == 0:
                    if board[x+i][y] == 7:
                        q.append((x+i, y, cnt+1))
                        visit[x+i][y] = 1
                    elif board[x+i][y] == -1:
                        q.append((x+i-1, y, cnt+1))
                        visit[x+i-1][y] = 1
                        continue

                    if x+i == 4 and board[x+i][y] == 0:
                        q.append((4, y, cnt+1))
                        visit[4][y] = 1

        for i in range(2, 5):
            if 0 <= y-i:
                if visit[x][y-i] == 0:
                    if board[x][y-i] == 7:
                        q.append((x, y-i, cnt+1))
                        visit[x][y-i] = 1
                    elif board[x][y-i] == -1:
                        q.append((x, y-i+1, cnt+1))
                        visit[x][y-i+1] = 1
                        continue

                    if y-i == 0 and board[x][y-i] == 0:
                        q.append((x, 0, cnt+1))
                        visit[x][0] = 1

            if y+i < 5:
                if visit[x][y+i] == 0:
                    if board[x][y+i] == 7:
                        q.append((x, y+i, cnt+1))
                        visit[x][y+i] = 1
                    elif board[x][y+i] == -1:
                        q.append((x, y+i-1, cnt+1))
                        visit[x][y+i-1] = 1
                        continue
                    
                    if y+i == 4 and board[x][y+i] == 0:
                        q.append((x, 4, cnt+1))
                        visit[x][4] = 1
    return -1

res = BFS(r, c)
print(res)
