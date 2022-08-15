import sys
from collections import deque
input = sys.stdin.readline

for _ in range(int(input())):
    N, K = map(int, input().split())
    times = [0] + list(map(int, input().split()))
    graph = [[] for _ in range(N+1)]
    d = [0 for _ in range(N+1)]
    dp = [0 for _ in range(N+1)]

    for _ in range(K):
        s, e = map(int, input().split())
        graph[s].append(e)
        d[e] += 1

    W = int(input())

    q = deque()
    for i in range(1, N+1):
        if d[i] == 0:
            q.append(i)
            dp[i] = times[i]
    
    while q:
        idx = q.popleft()
        for i in graph[idx]:
            d[i] -= 1
            dp[i] = max(dp[idx]+times[i], dp[i])
            if d[i] == 0:
                q.append(i)
    
    print(dp[W])

