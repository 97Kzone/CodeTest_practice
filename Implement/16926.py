import sys
from collections import deque
input = sys.stdin.readline

N, M, R = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

q = deque()
for i in range(min(N, M) // 2):
    x, y = i, i
        
    for j in range(i+1, N-i):
        x = j
        q.append(board[x][y])

    for j in range(i+1, M-i):
        y = j
        q.append(board[x][y])

    for j in range(i+1, N-i):
        x = N-j-1
        q.append(board[x][y])

    for j in range(i+1, M-i):
        y = M-j-1
        q.append(board[x][y])

    q.rotate(R)

    for j in range(i+1, N-i):
        x = j
        board[x][y] = q.popleft()

    for j in range(i+1, M-i):
        y = j
        board[x][y] = q.popleft()

    for j in range(i+1, N-i):
        x = N-j-1
        board[x][y] = q.popleft()

    for j in range(i+1, M-i):
        y = M-j-1
        board[x][y] = q.popleft()

for val in board:
    print(*val)