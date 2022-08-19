import sys
input = sys.stdin.readline

R, C = map(int, input().split())
board = [list(input().rstrip()) for _ in range(R)]
moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]
res = 0

def BFS():
    global res
    q = set()
    q.add((0, 0, board[0][0]))
    
    while q:
        x, y, std = q.pop()
        res = max(res, len(std))

        for dx, dy in moves:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < R and 0 <= ny < C:
                if board[nx][ny] not in std:
                    q.add((nx, ny, std+board[nx][ny]))

BFS()
print(res)