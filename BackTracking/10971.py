import sys
input = sys.stdin.readline

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

res, visit = 10**9, [0]*N
def check(n, c, cnt):
    global res
    if cnt == N:
        if board[n][0] != 0:
            res = min(res, c + board[n][0])
        return

    for i in range(N):
        if not visit[i] and board[n][i] != 0:
            visit[i] = 1
            check(i, c+board[n][i], cnt+1)
            visit[i] = 0

visit[0] = 1
check(0, 0, 1)
print(res)