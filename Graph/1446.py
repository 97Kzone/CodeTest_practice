import sys
input = sys.stdin.readline

N, D = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
d = [i for i in range(D+1)]

for i in range(D+1):
    d[i] = min(d[i], d[i-1]+1)

    for s, e, c in board:
        if i == s and e <= D:
            if d[i] + c < d[e]:
                d[e] = d[i] + c

print(d[D])