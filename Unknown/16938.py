from itertools import combinations as cb

N, L, R, X = map(int, input().split())
nums = list(map(int, input().split()))

nums.sort()
ans = 0
for i in range(2, N+1):
    for num in list(cb(nums, i)):
        if not L <= sum(num) <= R:
            continue

        if max(num) - min(num) < X:
            continue

        ans += 1
print(ans)
