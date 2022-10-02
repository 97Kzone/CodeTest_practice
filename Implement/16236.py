import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
board = []
moves = [(-1, 0), (0, -1), (1, 0), (0, 1)]
stat = [2, 0] #크기, 먹은 마리 수

for i in range(N):
    row = list(map(int, input().split()))
    for j in range(N):
        if row[j] == 9:
            start = (i, j)
    
    board.append(row)
    
def BFS(idx):
    i, j = idx
    dist = [[-1] * N for _ in range(N)]
    q = deque([(i, j)])
    dist[i][j] = 0

    while q:
        x, y = q.popleft()
        for dx, dy in moves:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < N and 0 <= ny < N:
                if board[nx][ny] <= stat[0]:
                    if dist[nx][ny] == -1:
                        q.append((nx, ny))
                        dist[nx][ny] = dist[x][y] + 1
        
    return dist

def find(dist):
    x, y = 0, 0
    m = 10 ** 9
    for i in range(N):
        for j in range(N):
            if dist[i][j] != -1 and 1 <= board[i][j] < stat[0]:
                if dist[i][j] < m:
                    x, y = i, j
                    m = dist[i][j]
    
    if m != 10 ** 9:
        return (x, y, m)
    else:
        return False

res = 0
while True:
    v = find(BFS(start))
    if v == False:
        print(res)
        break
    else:
        start = (v[0], v[1])
        res += v[2]
        board[start[0]][start[1]] = 0
        stat[1] += 1
    
    if stat[1] >= stat[0]:
        stat[0] += 1
        stat[1] = 0
