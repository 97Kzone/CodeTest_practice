#입구막기는 2개면 가능하다 즉, 1개로 못막으면? 답은 2개
import sys
from collections import deque
input = sys.stdin.readline
moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def check(i, j):
    q = deque()
    q.append((i, j))
    visit = [[0]*M for _ in range(N)]
    visit[i][j] = 1

    while q:
        x, y = q.popleft()
        if x == N-1 and y == M-1:
            return True
        
        for dx, dy in moves:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < N and 0 <= ny < M:
                if board[nx][ny] == 0 and visit[nx][ny] == 0:
                    q.append((nx, ny))
                    visit[nx][ny] = 1

    return False

N, M = map(int, input().split())
board, walls = [], []
    
for i in range(N):
    row = list(map(int, input().split()))
    for j in range(M):
        if (i == 0 and j == 0) or (i == N-1 and j == M-1):
            continue
        if row[j] == 0:
            walls.append((i, j))
    board.append(row)

#0개로도 막히나?
if not check(0, 0):
    print(0)
else:
    for i, j in walls:
        board[i][j] = 1
        if not check(0, 0):
            print(1)
            break
        board[i][j] = 0
    else:
        print(2)