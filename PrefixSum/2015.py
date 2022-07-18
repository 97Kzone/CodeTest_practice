import sys
from itertools import accumulate
from collections import defaultdict
input = sys.stdin.readline

N, K = map(int, input().split())
nums = list(map(int, input().split()))
nums = list(accumulate(nums))

dic = defaultdict(int)
cnt = 0

for i in range(N):
    if nums[i] == K:
        cnt += 1
    cnt += dic[nums[i]-K]

    dic[nums[i]] += 1

print(cnt)