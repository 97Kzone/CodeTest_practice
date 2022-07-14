import sys
from itertools import combinations as cb
from collections import deque
input = sys.stdin.readline

def BFS(i, j, check):
    q = deque()
    q.append((i, j))
    check[i][j] = 1
    
    v = 1
    flag = False    

    while q:
        i, j = q.popleft()
        for dx, dy in move:
            nx = i + dx
            ny = j + dy

            if 0 <= nx < N and 0 <= ny < M:
                if check[nx][ny] == 0:
                    if board[nx][ny] == 0:
                        flag = True
                    elif board[nx][ny] == 2:
                        check[nx][ny] = 1
                        v += 1
                        q.append((nx, ny))
    
    return v if not flag else -1



def play(turn):
    check = [[0] * M for _ in range(N)]
    cnt = 0

    for i, j in turn:
        board[i][j] = 1
    
    for i in range(N):
        for j in range(M):
            if board[i][j] == 2 and check[i][j] == 0:
                val = BFS(i, j, check)
                cnt += val if val != -1 else 0

    for i, j in turn:
        board[i][j] = 0
    
    return cnt
                

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
move = [(-1, 0), (1, 0), (0, -1), (0, 1)]


can = []
for i in range(N):
    for j in range(M):
        if board[i][j] == 0:
            can.append((i, j))

res = 0
for turn in cb(can, 2):
    res = max(res, play(turn))

print(res)