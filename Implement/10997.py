N = int(input())

if N == 1:
    print("*")
    exit()

def check(n, x, y):
    w = (4*n) - 3
    h = w+2

    for _ in range(w):
        board[x][y] = "*"
        y -= 1
    y += 1
    for _ in range(h):
        board[x][y] = "*"
        x += 1
    x -= 1
    for _ in range(w):
        board[x][y] = "*"
        y += 1
    y -= 1
    for _ in range(h-2):
        board[x][y] = "*"
        x -= 1
    x += 1
    board[x][y] = "*"
    y -= 1
    board[x][y] = "*"

    if n == 2:
        board[x][y-1] = "*"
        board[x+1][y-1] = "*"
        board[x+2][y-1] = "*"
        return
    
    check(n-1, x, y-1)

W = (4*N)-3
H = W+2

board = [[' '] * W for _ in range(H)]

check(N, 0, W-1)
for r in board:
    print(*r)