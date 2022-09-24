import sys
input = sys.stdin.readline

moves = [(-1, 0), (0, 1), (1, 0), (0, -1)]

#빈칸 0, 벽 1, 청소 2
def check(x, y, d):
    global res
    if board[x][y] == 0:
        board[x][y] = 2
        res += 1

    for _ in range(4):
        nd = (d + 3) % 4
        dx, dy = moves[nd][0], moves[nd][1]

        nx = x + dx
        ny = y + dy

        if board[nx][ny] == 0:
            check(nx, ny, nd)
            return
        
        d = nd
    
    nd = (d + 2) % 4
    nx = x + moves[nd][0]
    ny = y + moves[nd][1]

    if board[nx][ny] == 1:
        return

    check(nx, ny, d)
     
N, M = map(int, input().split())
r, c, a = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

res = 0
check(r, c, a)
print(res)            
        
