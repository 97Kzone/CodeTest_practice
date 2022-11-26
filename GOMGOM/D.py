import sys
input = sys.stdin.readline

N = int(input())

#상하좌우 가장 멀리 있는놈은 좌표가 어디일까
u, d, l, r = N, 0, N, 0
for i in range(N):
    row = list(input())
    for j in range(N):
        if row[j] == "G":
            u = min(u, i)
            d = max(d, i)
            l = min(l, j)
            r = max(r, j)

res = min(N-u-1, d) + min(N-l-1, r)
print(res)
