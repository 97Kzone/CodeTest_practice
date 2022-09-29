import sys
input = sys.stdin.readline

N = int(input())
point = [list(map(int, input().split())) for _ in range(N)]

t = 0
for i in range(1, N):
    t += abs(point[i][0] - point[i-1][0]) + abs(point[i][1] - point[i-1][1])

res = 10**9
for i in range(1, N-1):
    l = abs(point[i][0] - point[i-1][0]) + abs(point[i][1] - point[i-1][1])
    r = abs(point[i+1][0] - point[i][0]) + abs(point[i+1][1] - point[i][1])
    n = abs(point[i+1][0] - point[i-1][0]) + abs(point[i+1][1] - point[i-1][1])

    res = min(res, t-(l+r-n))

print(res)


