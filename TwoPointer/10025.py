import sys
input = sys.stdin.readline

N, K = map(int, input().split())

ice = []
for _ in range(N):
    g, x = map(int, input().split())
    ice.append((x, g))

ice.sort(key = lambda x : x[0])

i, j = 0, 1
res, s = 0, ice[0][1]
while j < N and i <= j:
    if abs(ice[i][0] - ice[j][0]) <= 2 * K:
        s += ice[j][1]
        j += 1
    else:
        s -= ice[i][1]
        i += 1

    res = max(res, s)

print(res)