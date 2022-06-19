N = int(input())

dp = [0] * (N+1)
dp[0], dp[1]= 1, 1

if N <= 2:
    print(N)
else:    
    for i in range(2, N+1):
        if i % 2 == 0:
            dp[i] = (dp[i-1] + dp[i//2]) % 1000000000
        else:
            dp[i] = dp[i-1]

    print(dp[N])