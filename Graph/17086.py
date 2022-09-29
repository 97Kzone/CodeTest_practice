import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
moves = [(-1, 0), (-1, 1), (-1, -1), (1, 0), (1, 1), (1, -1), (0, -1), (0, 1)]

q = deque()
board = []
for i in range(N):
    row = list(map(int, input().split()))
    for j in range(M):
        if row[j] == 1:
            q.append((i, j))
    board.append(row)

def BFS():
    while q:
        x, y = q.popleft()

        for dx, dy in moves:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < N and 0 <= ny < M:
                if board[nx][ny] == 0:
                    q.append((nx, ny))
                    board[nx][ny] = board[x][y] + 1

BFS()
print(max(map(max, board))-1)