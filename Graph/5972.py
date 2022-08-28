import sys, heapq as hq
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
d = [10e9 for _ in range(N+1)]

def check():
    q = []
    hq.heappush(q, (0, 1))
    d[1] = 0

    while q:
        dist, idx = hq.heappop(q)

        if d[idx] < dist:
            continue
        
        for i in graph[idx]:
            c = dist + i[1]

            if c < d[i[0]]:
                d[i[0]] = c
                hq.heappush(q, (c, i[0]))

for _ in range(M):
    s, e, c = map(int, input().split())
    graph[s].append((e, c))
    graph[e].append((s, c))

check()
print(d[-1])