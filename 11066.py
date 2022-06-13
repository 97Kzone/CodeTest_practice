import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    K = int(input())
    files = list(map(int, input().split()))
    dp = [[0] * K for _ in range(K)]

    cost = [0]
    for file in files:
        cost.append(cost[-1] + file)
    
    for i in range(1, K+1):
        for j in range(K-i):
            k = i + j
            dp[j][k] = 987654321
            for x in range(j, k):
                dp[j][k] = min(dp[j][k], dp[j][x] + dp[x+1][k] + cost[k+1] - cost[j])
    
    print(dp[0][K-1])


