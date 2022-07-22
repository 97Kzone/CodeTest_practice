import sys
input = sys.stdin.readline

N, K = map(int, input().split())
ch = [int(input()) for _ in range(N)]
ch.sort()

def check(ch, i):
    tmp = 0
    for c in ch:
        if c >= i:
            break
        tmp += i - c
    return tmp

res, l, r = 0, ch[0], ch[-1]+K
while l <= r:
    m = (l + r) // 2
    if check(ch, m) <= K:
        res = m
        l = m + 1
    else:
        r = m - 1
print(res)
