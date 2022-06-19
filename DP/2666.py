N = int(input())
open1, open2 = map(int, input().split())
L = int(input())
doors = [int(input()) for _ in range(L)]

dp = [[[[0] for _ in range(N+1)] for _ in range(N+1)] for _ in range(N+1)]

def check(idx, d1, d2):
    if idx == L:
        return 0
    
    v = doors[idx]
    dp[v][d1][d2] = min(abs(v-d1) + check(idx+1, v, d2), abs(v-d2) + check(idx+1, d1, v))
    return dp[v][d1][d2]

print(check(0, open1, open2))
