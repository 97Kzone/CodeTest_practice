import sys
sys.setrecursionlimit(10**9)
from collections import defaultdict
input = sys.stdin.readline

def DFS(now):
    global res
    dp[now] = 1
    
    for i in v[now]:
        if not dp[i]:
            dp[now] += DFS(i)

    res += std - (N-dp[now]) * (N-dp[now]-1) // 2
    return dp[now]

N = int(input())
v = defaultdict(list)
dp = [0] * 300001
std = N * (N-1) // 2

res = 0
for _ in range(N-1):
    a, b = map(int, input().split())
    v[a].append(b)
    v[b].append(a)

DFS(1)
print(res-std) 