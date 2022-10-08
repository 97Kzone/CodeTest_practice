import sys
input = sys.stdin.readline

N, H = map(int, input().split())
s, j = [0]*(H+1), [0]*(H+1)

for i in range(N):
    if i % 2 == 0:
        s[int(input())] += 1
    else:
        j[int(input())] += 1

for i in range(H-1, 0, -1):
    s[i] += s[i+1]
    j[i] += j[i+1]

res, cnt = 0, N
for i in range(1, H+1):
    v = s[i] + j[H-i+1]
    if cnt > v:
        cnt = v
        res = 1
    elif cnt == v:
        res += 1

print(cnt, res)