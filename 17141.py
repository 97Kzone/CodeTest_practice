from collections import deque
from copy import deepcopy
from itertools import combinations as cb
from sre_compile import isstring


N, M = map(int, input().split())

map = [list(map(int, input().split())) for _ in range(N)]
move = [[-1, 0], [1, 0], [0, -1], [0, 1]]
bombs = []

#폭탄 위치 체크
def find():
    for i in range(N):
        for j in range(N):
            if map[i][j] == 2:
                bombs.append([i, j])

    for bomb in list(cb(bombs, M)):
        bfs(bomb)

def bfs(bomb):
    q = deque()
    map2 = deepcopy(map)
    
    for v1, v2 in bomb:
        map2[v1][v2] = "0"
        q.append([v1, v2, 0])

    #폭탄을 터트리고 1을 제외한 위치에 전염 가능
    while q:
        x, y, time = q.popleft()
        time = int(time)

        for dx, dy in move:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < N and 0 <= ny < N:
                if map2[nx][ny] == 0 or map2[nx][ny] == 2:
                    map2[nx][ny] = str(time+1)
                    q.append([nx, ny, str(time+1)])
    check(map2)

res = set()
def check(map):
    val = 0
    for i in range(N):
        for j in range(N):
            if map[i][j] == 0:
                return

            if isstring(map[i][j]):
                val = max(val, int(map[i][j]))
                
    res.add(val)

find()
if res:
    print(min(res))
else:
    print(-1)