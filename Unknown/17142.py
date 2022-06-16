from collections import deque
from copy import deepcopy
from itertools import combinations as cb
from sre_compile import isstring
import sys

N, M = map(int, input().split())
map = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
move = [[-1, 0], [1, 0], [0, -1], [0, 1]]
bombs = []

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

    for i, j in bomb:
        map2[i][j] = "0"
        q.append([i, j, 0])
    
    while q:
        x, y, time = q.popleft()
        time = int(time)

        for dx, dy in move:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < N and 0 <= ny < N:
                #활성화 안된 폭탄을 만나면
                if map2[nx][ny] == 2:
                    map2[nx][ny] = str(time)
                    continue

                if map2[nx][ny] == 0:
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
            
            if not [i, j] in bombs:
                val = max(val, int(map[i][j]))
    
    res.add(val)

find()
if res:
    print(min(res))
else:
    print(-1)


# 시간 초과 실패 어디서 더 줄여야할까 ?