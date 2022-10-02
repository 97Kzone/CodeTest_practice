import sys
input = sys.stdin.readline

N, M, R = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
comm = list(map(int, input().split()))

def c1():
    for i in range(N//2):
        board[N-1-i], board[i] = board[i], board[N-1-i]

    return board

def c2():
    board2 = []
    for r in board:
        for i in range(M//2):
            r[M-1-i], r[i] = r[i], r[M-1-i]
        board2.append(r)

    return board2

def c3():
    board3 = [[0] * N for _ in range(M)]

    for i in range(N):
        for j in range(M):
            board3[j][N-1-i] = board[i][j]

    return board3

def c4():
    board4 = [[0] * N for _ in range(M)]

    for i in range(M):
        for j in range(N):
            board4[i][j] = board[j][M-1-i]

    return board4

def c5():
    board5 = [[0] * M for _ in range(N)]
    n, m = N//2, M//2
    for i in range(n):
        for j in range(m):
            board5[i][j+m] = board[i][j]
    
    for i in range(n):
        for j in range(m, M):
            board5[i+n][j] = board[i][j]
    
    for i in range(n, N):
        for j in range(m, M):
            board5[i][j - m] = board[i][j]

    for i in range(n, N):
        for j in range(m):
            board5[i-n][j] = board[i][j]

    return board5

def c6():
    board6 = [[0] * M for _ in range(N)]
    n, m = N//2, M//2

    for i in range(n):
        for j in range(m):
            board6[i+n][j] = board[i][j]
        
    for i in range(n, N):
        for j in range(m):
            board6[i][j+m] = board[i][j]
    
    for i in range(n, N):
        for j in range(m, M):
            board6[i-n][j] = board[i][j]
    
    for i in range(n):
        for j in range(m, M):
            board6[i][j-m] = board[i][j]

    return board6

for num in comm:
    N, M = len(board), len(board[0])
    if num == 1:
        board = c1()
    elif num == 2:
        board = c2()
    elif num == 3:
        board = c3()
    elif num == 4:
        board = c4()
    elif num == 5:
        board = c5()
    else:
        board = c6()

for row in board:
    print(*row)