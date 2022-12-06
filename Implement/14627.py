import sys
input = sys.stdin.readline

N, M = map(int, input().split())
nums = [int(input()) for _ in range(N)]

i, j = 0, max(nums)
res = 0
while i <= j:
    m = (i+j)//2
    m = 1 if m == 0 else m

    tmp = 0
    for v in nums:
        tmp += v//m
    if tmp >= M:
        res = m
        i = m+1
    else:
        j = m-1

ans = 0
for v in nums:
    if M <= 0:
        ans += v
    else:
        d, m = divmod(v, res)
        if M >= d:
            M -= d
            ans += m
        else:
            ans += (d-M)*res
            M = 0

print(ans)