N = int(input())

dp = [[0] * 10 for _ in range(N+1)]
dp[1] = [0, 1, 1, 1, 1, 1, 1, 1, 1, 1]

for i in range(2, N+1):
    for j in range(1, 10):
        if j < 3:
            dp[i][j] = sum(dp[i-1][j-1:j+3]) 
        elif 3 <= j <= 7:
            dp[i][j] = sum(dp[i-1][j-2:j+3]) 
        else:
            dp[i][j] = sum(dp[i-1][j-2:]) 
        
        dp[i][j] %= 987654321

print(sum(dp[N]) % 987654321)