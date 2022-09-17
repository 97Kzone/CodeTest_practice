from copy import deepcopy
import sys
sys = sys.stdin.readline

r, c, n = map(int, input().split())

board = [list(input()) for _ in range(r)]
board2 = [["O"] * c for _ in range(r)]
board3 = [["O"] * c for _ in range(r)]
moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]

for i in range(r):
    for j in range(c):
        if board[i][j] == "O":
            board2[i][j] = "."

            for dx, dy in moves:
                nx = i + dx
                ny = j + dy

                if 0 <= nx < r and 0 <= ny < c:
                    board2[nx][ny] = "."

for i in range(r):
    for j in range(c):
        if board2[i][j] == "O":
            board3[i][j] = "."

            for dx, dy in moves:
                nx = i + dx
                ny = j + dy

                if 0 <= nx < r and 0 <= ny < c:
                    board3[nx][ny] = "."
        
#4가지 경우
if n <= 1:
    for r in board:
        print("".join(r))
else:
    if n % 2 == 0:
        for _ in range(r):
            print('O'*c)
    elif n % 4 == 1:
        for r in board3:
            print("".join(r))
    elif n % 4 == 3:
        for r in board2:
            print("".join(r))

