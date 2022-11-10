import sys
from collections import defaultdict
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def dfs(now, pa) :
    size[now] = 1
    for ch, v in g[now] : 
        
        if ch != pa : 
            dfs(ch, now)
            dist[now] += size[ch] * v + dist[ch]
            size[now] += size[ch]
            
def dfs2(now, pa) : 
    for ch, v in g[now]: 
        if ch != pa  : 
            dist[ch] = dist[now] + v * (N-size[ch]-size[ch])
            dfs2(ch, now)

N = int(input())
g = defaultdict(list)
for _ in range(N-1):
    s, e, v = map(int, input().split())
    g[s].append((e, v))
    g[e].append((s, v))

size = [0] * (N+1)
dist = [0] * (N+1)

dfs(1,1)
dfs2(1,1)

for idx in range(1, N+1) : 
    print(dist[idx])