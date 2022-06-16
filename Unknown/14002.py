N = int(input())
nums = list(map(int, input().split()))
dp = [1 for _ in range(N)]

for i in range(1, N):
    for j in range(i):
        if nums[i] > nums[j]:
            dp[i] = max(dp[i], dp[j]+1)

print(max(dp))

val, idx = max(dp), dp.index(max(dp))
res = []
while val >= 1:
    for i in range(idx, -1, -1):
        if dp[i] == val:
            res.append(nums[i])
            idx = i
            break
    val -= 1

print(*res[::-1])




