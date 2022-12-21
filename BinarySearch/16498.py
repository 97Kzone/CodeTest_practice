import sys
input = sys.stdin.readline

def check(v, nums):
    l, r = 0, len(nums)-1

    while l <= r:
        m = (l+r)//2
        if l == m:
            return nums[m]
        
        if nums[m] == v:
            return v
        elif nums[m] < v:
            l = m
        else:
            r = m
    
A, B, C = map(int, input().split())
na = list(map(int, input().split()))
nb = list(map(int, input().split()))
nc = list(map(int, input().split()))

na.sort()
nb.sort()
nc.sort()

res = 10**10
for v1 in na:
    v2 = check(v1, nb)
    v3 = check(v1, nc)
    res = min(res, abs(max(v1, v2, v3)-min(v1, v2, v3)))

for v1 in nb:
    v2 = check(v1, na)
    v3 = check(v1, nc)
    res = min(res, abs(max(v1, v2, v3)-min(v1, v2, v3)))

for v1 in nc:
    v2 = check(v1, na)
    v3 = check(v1, nb)
    res = min(res, abs(max(v1, v2, v3)-min(v1, v2, v3)))

print(res)
