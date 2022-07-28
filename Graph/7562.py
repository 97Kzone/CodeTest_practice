import sys
from collections import deque
input = sys.stdin.readline

def BFS(i, j):
    q = deque()
    q.append((i, j, 0))
    check[i][j] = 1

    while q:
        x, y, cnt = q.popleft()

        if x == ex and y == ey:
            return cnt
        
        for dx, dy in moves:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < N and 0 <= ny < N:
                if check[nx][ny] == 0:
                    check[nx][ny] = 1
                    q.append((nx, ny, cnt+1))


for _ in range(int(input())):
    moves = [(2, 1), (2, -1), (1, 2), (1, -2), (-1, -2), (-1, 2), (-2, 1), (-2, -1)]
    
    N = int(input())
    sx, sy = map(int, input().split())
    ex, ey = map(int, input().split())

    check = [[0] * N for _ in range(N)]
    res = BFS(sx, sy)
    print(res)