import sys
from collections import defaultdict
input = sys.stdin.readline

N = int(input())
check = defaultdict(int)

for _ in range(N):
    s, e = map(int, input().split())
    check[s] += 1
    check[e] -= 1

k = sorted(check.keys())

s, e, M, cnt = 0, 0, 0, 0
flag = 0
for i in k:
    cnt += check[i]
    if cnt > M:
        M = cnt
        s = i
        flag = 1
    elif cnt < M and flag:
        e = i
        flag = 0

print(M)
print(s, e)


