import sys
sys.setrecursionlimit(10 ** 6)

input = sys.stdin.readline

N, M = map(int, input().split())

def check(idx):
    if idx >= N:
        return 0

    if dp[idx] < 1000:
        return dp[idx]

    val = M - names[idx]

    for i in range(idx+1, N+1):
        if val < 0:
            break
            
        if i == N:
            dp[idx] = 0
            break

        dp[idx] = min(dp[idx], val * val + check(i))
        val -= names[i] + 1

    return dp[idx]

names = [int(input()) for _ in range(N)]
dp = [1000 for _ in range(N)]
dp[-1] = 0

print(check(0))



    

