import sys
input = sys.stdin.readline

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

while N != 1:
    std = [[0] * (N//2) for _ in range(N//2)]
    for i in range(0, N, 2):
        for j in range(0, N, 2):
            tmp = [board[i][j], board[i][j+1], board[i+1][j], board[i+1][j+1]]
            tmp.sort()
            std[i//2][j//2] = tmp[-2]
    
    board = std
    N //= 2

print(board[0][0])

