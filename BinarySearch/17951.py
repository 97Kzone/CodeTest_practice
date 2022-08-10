import sys
input = sys.stdin.readline

N, K = map(int, input().split())
nums = list(map(int, input().split()))

l, r = 0, sum(nums)
res = 0
while l <= r:
    m = (l + r) // 2
    g, s = 0, 0

    for num in nums:
        s += num
        if s >= m:
            g += 1
            s = 0
        
    if g >= K:
        res = m
        l = m+1
    else:
        r = m-1

print(res)