def dfs(i, cnt):
    global res

    res = max(res, cnt)

    for nx in board[i]:
        if visit[nx] == 0:
            visit[nx] = 1
            dfs(nx, cnt+1)
            visit[nx] = 0

for t in range(1, int(input())+1):
    N, M = map(int, input().split())

    if N == 1:
        res = 1
    else:
        board = [[] for _ in range(N+1)]

        for _ in range(M):
            s, e = map(int, input().split())
            board[s].append(e)
            board[e].append(s)
        res = 0
        visit = [0] * (N+1)
        for i in range(1, N+1):
            visit[i] = 1
            dfs(i, 1)

    print("#{} {}".format(t, res))