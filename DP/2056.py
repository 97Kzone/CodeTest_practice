import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
d = [0 for _ in range(N+1)]
graph = [[] for _ in range(N+1)]
dp = [0 for _ in range(N+1)]
times = [0]

for i in range(1, N+1):
    tmp = list(map(int, input().split()))
    times.append(tmp[0]) 

    if tmp[1] != 0:
        for j in range(2, len(tmp)):
            graph[tmp[j]].append(i)
    d[i] = tmp[1]

q = deque()
for i in range(1, N+1):
    if d[i] == 0:
        q.append(i)
        dp[i] = times[i]

while q:
    idx = q.popleft()
    for i in graph[idx]:
        d[i] -= 1
        dp[i] = max(dp[idx] + times[i], dp[i])
        if d[i] == 0:
            q.append(i)

print(max(dp))

