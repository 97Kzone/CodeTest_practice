import sys
from itertools import accumulate
input = sys.stdin.readline

N, W  = map(int, input().split())
w3, w5 = [], []

for _ in range(N):
    w, s = map(int, input().split())
    if w == 3:
        w3.append(s)
    else:
        w5.append(s)

w3.sort(reverse=True)
w5.sort(reverse=True)

s3 = [0] + list(accumulate(w3)) 
s5 = [0] + list(accumulate(w5))

std = min(len(w5), W//5)
ans, i = 0, 0

while i <= std:
    tmp = s5[i]
    re = (W - (i * 5)) // 3

    tmp += s3[min(re, len(w3))]
    ans = max(ans, tmp)
    i += 1

print(ans)
