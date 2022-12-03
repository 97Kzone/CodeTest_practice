#해설 보고 작성
import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))

res = N-2

for i in range(N):
    for j in range(i+1, N):
        tmp = max(nums[j]-nums[i], nums[i]-nums[j])
        k = j-i

        if tmp % k:
            continue

        d = (nums[j]-nums[i])//k

        cnt = 0
        for t in range(N):
            std = nums[i]+(d*(t-i))
            if std == nums[t]:
                cnt += 1

        res = min(res, N-cnt)

print(res)