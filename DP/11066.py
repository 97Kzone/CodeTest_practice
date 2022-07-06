import sys
input = sys.stdin.readline

for _ in range(int(input())):
    N = int(input())
    files = list(map(int, input().split()))

    check = [0 for _ in range(N+1)]

    for i in range(1, N+1):
        check[i] = check[i-1] + files[i-1]

    dp = [[0] * N for _ in range(N)]
    for i in range(1, N):
        for j in range(N-i):
            k = i+j

            if i == 1:
                dp[j][k] = files[j] + files[k]
                continue

            dp[j][k] = 1e9

            for x in range(j, k):
                dp[j][k] = min(dp[j][k], dp[j][x] + dp[x+1][k] + check[k+1]-check[j])

    print(dp[0][N-1])