import sys
input = sys.stdin.readline

N, M, B = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

res, v = 10**9, 0

for i in range(257): #땅 높이
    b1, b2= 0, 0
    for x in range(N):
        for y in range(M):
            if board[x][y] > i:
                b1 += board[x][y] - i
            else:
                b2 += i - board[x][y]

    if b2 > b1 + B:
        continue

    cnt = b1 * 2 + b2

    if cnt <= res:
        res = cnt
        v = i

print(res, v)