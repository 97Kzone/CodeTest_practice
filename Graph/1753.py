import sys, heapq as hq
input = sys.stdin.readline

def ds(idx):
    q = []
    hq.heappush(q, (0, idx))
    dt[idx] = 0

    while q:
        dist, now = hq.heappop(q)

        if dt[now] < dist:
            continue
            
        for k, v in graph[now]:
            cost = dist + v
            if cost < dt[k]:
                dt[k] = cost
                hq.heappush(q, (cost, k))

V, E = map(int, input().split())
K = int(input())
graph = [[] for _ in range((V+1))]
dt = [10**9] * (V+1)

for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))

ds(K)
for v in dt[1:]:
    print("INF" if v == 10**9 else v)
