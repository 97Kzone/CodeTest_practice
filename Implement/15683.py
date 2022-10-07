import sys
from copy import deepcopy
input = sys.stdin.readline

N, M = map(int, input().split())
cctv, board = [], []
moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]
dir = [[], [[0], [1], [2], [3]], [[0, 1], [2, 3]], [[0, 2], [0, 3], [1, 2], [1, 3]],
 [[0, 1, 2], [1, 2, 3], [2, 3, 0], [0, 1, 3]], [[0, 1, 2, 3]]]

def DFS(board, idx):
    global res
    if idx == len(cctv):
        res = min(res, count(board))
        return
    
    board2 = deepcopy(board)
    x, y, t = cctv[idx]

    for d in dir[t]:
        check(x, y, d, board2)
        DFS(board2, idx+1)
        board2 = deepcopy(board)

def check(x, y, d, board):
    for i in d:
        nx, ny = x, y

        while True:
            nx += moves[i][0]
            ny += moves[i][1]

            if 0 <= nx < N and 0 <= ny < M:
                if board[nx][ny] == 6:
                    break
                
                if board[nx][ny] == 0:
                    board[nx][ny] = "X"
            else:
                break

def count(board):
    v = 0
    for i in range(N):
        for j in range(M):
            if board[i][j] == 0:
                v += 1
        
    return v

for i in range(N):
    row = list(map(int, input().split()))
    for j in range(M):
        if 0 < row[j] < 6:
            cctv.append((i, j, row[j]))
    board.append(row)

res = 10**9
DFS(board, 0)
print(res)