import sys
from collections import defaultdict
from itertools import accumulate

input = sys.stdin.readline

N, K = map(int, input().split())
nums = list(map(int, input().split()))
sum = [0] + list(accumulate(nums))

dic = defaultdict(int)
res = 0

for i in range(1, N+1):
    tmp = sum[i] - (K * i)

    res += dic[tmp]
    dic[tmp] += 1
    print(res, dic)

print(res + dic[0])