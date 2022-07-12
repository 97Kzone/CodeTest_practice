import sys
from collections import defaultdict
sys.setrecursionlimit(10**9)

input = sys.stdin.readline

def DFS(v):
    check[v] = 1

    for i in dic[v]:
        if check[i] == 0:
            DFS(i)

N, M = map(int, input().split())
dic = defaultdict(list)

for _ in range(M):
    u, v = map(int, input().split())
    dic[u].append(v)
    dic[v].append(u)

check = [0] * (N+1)
cnt = 0

for i in range(1, N+1):
    if check[i] == 0:
        if len(dic[i]) == 0:
            cnt += 1
            check[i] = 1
        else:
            DFS(i)
            cnt += 1

print(cnt)