import sys
from itertools import accumulate
input = sys.stdin.readline

N, M = map(int, input().split())
board = list(map(int, input().split()))
order = [list(map(int, input().split())) for _ in range(M)]
check = [0 for _ in range(N+1)]
for s, e, c in order:
    check[s-1] += c
    check[e] -= c
    
check = list(accumulate(check))
for i in range(N):
    board[i] += check[i]

print(*board)