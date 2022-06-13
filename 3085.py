import sys
input = sys.stdin.readline

N = int(input())
candies = [[0] * (N+2) for _ in range(N+2)]
datas = [list(input().rstrip("\n")) for _ in range(N)]

def swap(candies, x, y, nx, ny):
    candies[x][y], candies[nx][ny] = candies[nx][ny], candies[x][y]

def check(candies, x, y):
    xcnt = 1
    xmax = 0
    for i in range(1, N+1):
        

for i in range(N):
    for j in range(N):
        candies[i+1][j+1] = datas[i][j]

col, row = [1, 0, -1 ,0], [0, 1, 0, -1]

for i in range(1, N+1):
    for j in range(1, N+1):
        for k in range(4):
            nx, ny = i + col[k], i + row[k]

            swap(candies, i, j, nx, ny)
