N = int(input())
roads = list(input())

dp = [1e9] * N
dp[0] = 0

def check(x):
    if x == "B":
        return 'J'
    elif x == "O":
        return "B"
    elif x == "J":
        return "O"

for i in range(1, N):
    tmp = check(roads[i])
    for j in range(i):
        if roads[j] == tmp:
            dp[i] = min(dp[i], dp[j] + (i-j)**2)

print(dp[-1] if dp[-1] != 1e9 else -1)
