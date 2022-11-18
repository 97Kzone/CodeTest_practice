for t in range(1, int(input())+1):
    N, K = map(int, input().split())
    dp = [[0] * (K+1) for _ in range(N+1)]

    board = [[0, 0]] + [list(map(int, input().split())) for _ in range(N)]
    for i in range(1, N+1):
        for j in range(1, K+1):
            w, v = board[i]

            if j < w:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-w]+v)

    print("#{} {}".format(t, dp[N][K]))