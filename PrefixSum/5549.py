import sys
input = sys.stdin.readline

M, N = map(int, input().split())
K = int(input())

count = [[[0, 0, 0] for _ in range(N)] for _ in range(M)]
maps = [list(input()) for _ in range(M)]

for i in range(M):
    for j in range(N):
        if maps[i][j] == "J":
            count[i][j][0] += 1
        elif maps[i][j] == "O":
            count[i][j][1] += 1
        else:
            count[i][j][2] += 1

sum = [[[0, 0 ,0] for _ in range(N+1)]]
for val in count:
    for i in range(1, N):
        for k in range(3):
            val[i][k] += val[i-1][k]
    val.insert(0, [0, 0, 0])
    sum.append(val)
sum = list(zip(*sum))

for i in range(N+1):
    for j in range(1, M+1):
        for k in range(3):
            sum[i][j][k] += sum[i][j-1][k]

sum = list(zip(*sum))

for _ in range(K):
    x1, y1, x2, y2 = map(int, input().split())
    J = sum[x2][y2][0] - sum[x1-1][y2][0] - sum[x2][y1-1][0] + sum[x1-1][y1-1][0]
    O = sum[x2][y2][1] - sum[x1-1][y2][1] - sum[x2][y1-1][1] + sum[x1-1][y1-1][1]
    I = sum[x2][y2][2] - sum[x1-1][y2][2] - sum[x2][y1-1][2] + sum[x1-1][y1-1][2]

    print(J, O, I)