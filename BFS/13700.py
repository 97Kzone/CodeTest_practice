import sys
from collections import deque
input = sys.stdin.readline

N, S, D, F, B, K = map(int, input().split())
board = [0] * (N+1)
board[D] = -1

if K != 0:
    p = list(map(int, input().split()))
    for v in p:
        board[v] = 2

visit = [0] * (N+1)
visit[S] = 1

q = deque()
q.append((S, 0))
res = 0
while q:
    x, cnt = q.popleft()

    if x == D:
        res = cnt
        break

    for i in range(2):
        nx = (x+F) if i == 0 else (x-B)

        if 0 <= nx <= N:
            if board[nx] != 2 and not visit[nx]:
                visit[nx] = 1
                q.append((nx, cnt+1))

print(res if res != 0 else "BUG FOUND")