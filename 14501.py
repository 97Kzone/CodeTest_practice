N = int(input())

plan = [list(map(int, input().split())) for _ in range(N)]

dp = [0] * (N+1)
for i in range(N):
    dp[i] = max(dp[i-1], dp[i])
    if i + plan[i][0] < N+1:
        dp[i + plan[i][0]] = max(dp[i] + plan[i][1], dp[i + plan[i][0]])

print(max(dp))

# 브루트 포스 연습문제인데 빡쳐서 dp로 해결
# 실버 3, 정답률 48프로 solved 22-02-09