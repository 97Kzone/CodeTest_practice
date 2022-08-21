import sys, heapq as hq
input = sys.stdin.readline

def check(start):
    q = []
    hq.heappush(q, (0, start))
    dist = [10e9] * (N+1)
    dist[start] = 0

    while q:
        d, idx = hq.heappop(q)

        if dist[idx] < d:
            continue

        for nx, nd in graph[idx]:
            c = d + nd

            if dist[nx] > c:
                dist[nx] = c
                hq.heappush(q, (c, nx))

    return dist

N, M, X = map(int, input().split())
graph = [[] for _ in range(N+1)] 

for _ in range(M):
    s, e, c = map(int, input().split())
    graph[s].append((e, c))

res = 0
for i in range(1, N+1):
    s1 = check(i)[X]
    s2 = check(X)[i]
    res = max(res, s1 + s2)

print(res)