import sys
from collections import deque
input = sys.stdin.readline

def BFS(x, y):
    global res
    q = deque()
    q.append((x, y))
    visit[x][y] = 1

    while q:
        x, y = q.popleft()
        for dx, dy in moves:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < N and 0 <= ny < M:
                if board[nx][ny] == 1 and visit[nx][ny] == 0:
                    q.append((nx, ny))
                    visit[nx][ny] = 1   
    
    res += 1

for _ in range(int(input())):
    res = 0
    M, N, K = map(int, input().split())
    moves = [(0, -1), (0, 1), (1, 0), (-1, 0)]
    
    board = [[0] * M for _ in range(N)]
    visit = [[0] * M for _ in range(N)]

    for _ in range(K):
        a, b = map(int, input().split())
        board[b][a] = 1
    
    res = 0 
    for i in range(N):
        for j in range(M):
            if board[i][j] == 1 and visit[i][j] == 0:
                BFS(i, j)
    
    print(res)