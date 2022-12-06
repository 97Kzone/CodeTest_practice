import sys
input = sys.stdin.readline

N = int(input())
T = 0
board = []
i, j = 1, 0
for _ in range(N):
    r = list(map(int, input().split()))
    for v in r:
        j = max(v, j)
        T += v
    board.append(r)

res = 0
while i <= j:
    m = (i+j) // 2

    tmp = 0
    for x in range(N):
        for y in range(N):
            tmp += board[x][y] if board[x][y] <= m else m
    
    if tmp / T >= 0.5:
        res = m
        j = m-1
    else:
        i = m+1

print(res)