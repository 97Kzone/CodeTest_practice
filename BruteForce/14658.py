import sys
input = sys.stdin.readline

N, M, L, K = map(int, input().split())
stars = [list(map(int, input().split())) for _ in range(K)]

res = 0
for i in range(K):
    for j in range(K):
        cnt = 0
        x = stars[i][0]
        y = stars[j][1]

        for nx, ny in stars:
            if x <= nx <= x+L and y <= ny <= y+L:
                cnt += 1

        res = max(res, cnt)
print(K-res)
