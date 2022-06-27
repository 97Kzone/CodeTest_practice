import sys
input = sys.stdin.readline

for _ in range(int(input())):
    N = int(input())
    coins = list(map(int, input().split()))
    values = int(input())

    dp = [0] * (values+1)
    dp[0] = 1    

    for coin in coins:
        for i in range(1, values+1):
            if i - coin >= 0:
                dp[i] += dp[i-coin]
    
    print(dp[-1])
