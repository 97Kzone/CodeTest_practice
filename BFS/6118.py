import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
board = [[] for _ in range(N+1)]

for _ in range(M):
    s, e = map(int, input().split())
    board[s].append(e)
    board[e].append(s)

visit = [-1] * (N+1)
visit[1] = 0 

q = deque()
q.append(1)

v = 0
while q:
    x = q.popleft()

    for nx in board[x]:
        if visit[nx] == -1:
            visit[nx] = visit[x] + 1
            v = max(visit[nx], v)

            q.append(nx)

i = visit.index(v)
cnt = visit.count(v)

print(i, v, cnt)
