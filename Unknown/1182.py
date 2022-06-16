from itertools import combinations as cb

N, S = map(int, input().split())
nums = list(map(int, input().split()))

res = 0

for i in range(1, N+1):
    temp = list(cb(nums, i))
    
    for val in temp:
        if sum(val) == S:
            res += 1

print(res)