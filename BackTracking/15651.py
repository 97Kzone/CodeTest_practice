from itertools import product as pd

N, M = map(int, input().split())
nums =  [i for i in range(1, N+1)]

res = list(pd(nums, repeat=M))

for val in res:
    print(*val)