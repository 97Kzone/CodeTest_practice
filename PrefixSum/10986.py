import sys
from itertools import accumulate
from collections import defaultdict
input = sys.stdin.readline

N, M = map(int, input().split())
nums = list(map(int, input().split()))
nums = list(accumulate(nums))
dic = defaultdict(int)
cnt = 0

for i in range(N):
    if nums[i] % M == 0:
        cnt += 1
    cnt += dic[nums[i] % M]
    dic[nums[i] % M] += 1

print(cnt)
            