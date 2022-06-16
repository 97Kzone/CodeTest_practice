N = int(input())
M = int(input())
vips =  [int(input()) for _ in range(M)]

dp = [0 for _ in range(N+1)] 
dp[0], dp[1], dp[2] = 1, 1, 2

for i in range(3, N+1):
    dp[i] = dp[i-1] + dp[i-2]

res, idx = 1, 0
if M > 0:
    for vip in vips:
        res *= dp[vip-idx-1]
        idx = vip

    res *= dp[N-idx]
else:
    res = dp[N]

print(res)