import sys
from bisect import bisect_left
input = sys.stdin.readline

N, M = map(int, input().split())
t, p = [], []

for _ in range(N):
    a, b = input().split()
    t.append(a)
    p.append(int(b))

for _ in range(M):
    tmp = int(input())
    print(t[bisect_left(p, tmp)])