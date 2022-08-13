import sys
input = sys.stdin.readline

N = int(input())
M = int(input())
lights = list(map(int, input().split()))

std, res = lights[0], lights[0]

for i in range(1, M):
    tmp = abs(std-lights[i])
    tmp = tmp//2 if tmp%2 == 0 else (tmp//2) + 1

    res = max(res, tmp)
    std = lights[i]

res = max(res, abs(N-lights[M-1]))
print(res)
