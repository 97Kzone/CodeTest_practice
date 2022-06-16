import sys

N = int(input())

Mines = [list(sys.stdin.readline().rstrip('\n')) for _ in range(N)]

def check(i, j):
    if 0 < i < N and 0 < j < N:
        Mines[i][j-1]
    return
for i in range(N):
    for j in range(N):
        if Mines[i][j] == "0":
            check(i, j)