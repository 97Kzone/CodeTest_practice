import sys
input = sys.stdin.readline

N, K, B = map(int, input().split())
std = [1] * (N+1)

for _ in range(B):
    std[int(input())] = 0

S = sum(std[1:K+1])
c = K - S

for i in range(2, N-K+2):
    S += std[i-1+K] - std[i-1]
    c = min(c, K-S)

    if c == 0:
        break

print(c)
