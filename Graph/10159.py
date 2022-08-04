import sys
from collections import Counter as C
input = sys.stdin.readline

N = int(input())
M = int(input())
check = [[0] * N for _ in range(N)]
cmp = [list(map(int, input().split())) for _ in range(M)]

#무거우면 1, 가벼우면 -1
for w, l in cmp:
    check[w-1][l-1] = 1
    check[l-1][w-1] = -1

#플로이드 와샬
for i in range(N):
    for j in range(N):
        for k in range(N):
            if check[j][i] == 1 and check[i][k] == 1:
                check[j][k] = 1
                check[k][j] = -1

            if check[j][i] == -1 and check[i][k] == -1:
                check[j][k] = -1
                check[k][j] = 1

for r in check:
    print(C(r)[0] - 1)