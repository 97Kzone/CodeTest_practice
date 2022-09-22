from itertools import permutations as pm

a, b = map(int, input().split())

nums = list(str(a))
res = -1
for v in pm(nums, len(nums)):
    if v[0] == '0':
        continue
    
    tmp = int("".join(v))
    if tmp < b:
        res = max(res, tmp)

print(res)
