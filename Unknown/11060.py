N = int(input())
board = list(map(int, input().split()))

dp = [100000] * N
dp[0] = 0

for i in range(N):
    for j in range(1, board[i]+1):
        if i+j >= N:
            break

        dp[i+j] = min(dp[i+j], dp[i]+1)
        
print(dp[-1] if dp[-1] != 100000 else -1)