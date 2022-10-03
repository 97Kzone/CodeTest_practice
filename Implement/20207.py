import sys
input = sys.stdin.readline

N = int(input())
board = [0] * 367
i, j = 366, 0

for _ in range(N):
    s, e = map(int, input().split())
    for v in range(s, e+1):
        board[v] += 1

    i = min(i, s)
    j = max(j, e)

res, cnt, m = 0, 0, 0
for v in board[i:j+2]:
    if v != 0:
        m = max(m, v)
        cnt += 1
    else:
        res += m * cnt
        cnt, m = 0, 0

print(res)