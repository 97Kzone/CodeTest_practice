import sys
input = sys.stdin.readline

N, K = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

for i in range(N):
    for j in range(N):
        for k in range(N):
            board[j][k] = min(board[j][k], board[j][i] + board[i][k])

res, visit = 10**9, [0] * N

def check(n, c, cnt):
    global res
    if cnt == N:
        res = min(res, c)
        return
    
    for i in range(N):
        if not visit[i]:
            visit[i] = 1
            check(i, c+board[n][i], cnt+1)
            visit[i] = 0

visit[K] = 1
check(K, 0, 1)
print(res)