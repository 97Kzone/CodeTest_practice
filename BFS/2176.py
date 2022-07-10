import sys
from collections import deque
input = sys.stdin.readline


def BFS(x, y, board):
    check = [[0] * M for _ in range(N)]

    q = deque()
    q.append([x, y, 1])
    check[0][0] = 1

    while q:
        x, y, cnt = q.popleft()
        if x == N-1 and y == M-1:
            return cnt

        for dx, dy in move:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < N and 0 <= ny < M:
                if board[nx][ny] == "1" and check[nx][ny] == 0:
                    q.append([nx, ny, cnt+1])

                    check[nx][ny] = 1

N, M = map(int, input().split())
board = [list(input().rstrip()) for _ in range(N)]
move = [(-1, 0), (1, 0), (0, -1), (0, 1)]
res = BFS(0, 0, board)

print(res)