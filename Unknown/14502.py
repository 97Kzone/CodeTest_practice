from collections import deque
from copy import deepcopy

N, M = map(int, input().split())
map = [list(map(int, input().split())) for _ in range(N)]

d = [[-1, 0], [1, 0], [0, -1], [0, 1]]
res = 0

def wall(cnt):
    if cnt == 3:
        bfs()
        return

    for i in range(N):
        for j in range(M):
            if map[i][j] == 0:
                map[i][j] = 1
                wall(cnt+1)
                map[i][j] = 0
    
def check(temp):
    global res
    cnt = 0

    for i in range(N):
        for j in range(M):
            if temp[i][j] == 0:
                cnt += 1

    res = max(res, cnt)

def bfs():
    q = deque()
    temp = deepcopy(map)

    for i in range(N):
        for j in range(M):
            temp[i][j] = map[i][j]

            if temp[i][j] == 2:
                q.append([i, j])
    
    while q:
        x, y = q.popleft()

        for c1, c2 in d:
            dx = x + c1
            dy = y + c2

            if 0 <= dx < N and 0 <= dy < M:
                if temp[dx][dy] == 0:
                    temp[dx][dy] = 2
                    q.append([dx, dy])
    
    check(temp)

wall(0)
print(res)