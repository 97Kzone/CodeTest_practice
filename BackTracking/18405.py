import sys
from collections import defaultdict, deque
input = sys.stdin.readline

d = defaultdict(list)
moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]

N, K = map(int, input().split())
board = []

for i in range(N):
    row = list(map(int, input().split()))
    for j, v in enumerate(row):
        if v != 0:
            d[v].append((i, j))
    board.append(row)

S, X, Y = map(int, input().split())
t = 0
while True:
    if t == S:
        break

    for i in range(1, K+1):
        q = deque(d[i])
        del d[i]

        while q:
            x, y = q.popleft()

            for dx, dy in moves:
                nx = x + dx
                ny = y + dy

                if 0 <= nx < N and 0 <= ny < N:
                    if board[nx][ny] == 0:
                        board[nx][ny] = i
                        d[i].append((nx, ny))

    t += 1

print(board[X-1][Y-1])
