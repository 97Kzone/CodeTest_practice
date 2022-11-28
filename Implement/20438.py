import sys
from itertools import accumulate as ac
input = sys.stdin.readline

N, K, Q, M = map(int, input().split())
stu = [0] * (N+3)
sleep = [0] * (N+3)
for v in list(map(int, input().split())):
    sleep[v] = 1

check = list(map(int, input().split()))
idx = []
for _ in range(M):
    s, e = map(int, input().split())
    idx.append((s, e))

for v in check:
    #졸면 보낼 수 없다
    if sleep[v] == 1:
        continue

    tmp = 1
    while tmp*v < N+3:
        if sleep[tmp*v] != 1:
            stu[tmp*v] = 1
        tmp += 1

res = 0
stu = list(ac(stu))

for s, e in idx:
    print(e-s+1-(stu[e]-stu[s-1]))