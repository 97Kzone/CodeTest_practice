import sys
input = sys.stdin.readline

R, C, T = map(int, input().split())
air = []
moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]
board = []

for i in range(R):
    row = list(map(int, input().split()))
    for j in range(C):
        if row[j] == -1:
            air.append(i)
    board.append(row)

def f1():
    tmp = [[0] * C for _ in range(R)]
    x1, x2 = air
    tmp[x1][0], tmp[x2][0] = -1, -1

    for x in range(R):
        for y in range(C):
            if board[x][y] != 0 and board[x][y] != -1:
                cnt = 0

                v = board[x][y] // 5
                for dx, dy in moves:
                    nx = x + dx
                    ny = y + dy

                    if 0 <= nx < R and 0 <= ny < C:
                        if tmp[nx][ny] >= 0:
                            tmp[nx][ny] += v
                            cnt += 1

                tmp[x][y] += board[x][y] - (v*cnt)
            
    return tmp

def f2(board):
    x1, x2 = air

    #위 배열
    for i in range(x1-1, -1, -1):
        board[i][0] = board[i-1][0]
    
    board[0] = board[0][1:C] + [0]

    for i in range(x1):
        board[i][C-1] = board[i+1][C-1]
    
    board[x1] = [-1, 0] + board[x1][1:C-1]

    #아래 배열
    for i in range(x2+1, R-1):
        board[i][0] = board[i+1][0]
    
    board[R-1] = board[R-1][1:C] + [0]

    for i in range(R-1, x2, -1):
        board[i][C-1] = board[i-1][C-1]

    board[x2] = [-1, 0] + board[x2][1:C-1]

    return board

for _ in range(T):
    board = f1()
    board = f2(board)

res = 0
for r in board:
    res += sum(r)

print(res+2)