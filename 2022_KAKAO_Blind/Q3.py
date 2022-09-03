from collections import defaultdict
import heapq as hq

def solution(n, paths, gates, summits):
    answer = [0, 10**8]
    dist = [10**8] * (n+1)
    graph = defaultdict(list)
    
    #중복이 주어지나?
    summits.sort()
    S = set(summits)
    
    for s, e, c in paths:
        graph[s].append((e, c))
        graph[e].append((s, c))
    
    q = []
    for gate in gates:
        hq.heappush(q, (0, gate))
    
    while q:
        d, now = hq.heappop(q)
        
        if now in S or d > dist[now]:
            continue
        
        for nxt, nd in graph[now]:
            t = max(d, nd)
            if t < dist[nxt]:
                dist[nxt] = t
                hq.heappush(q, (t, nxt))
    
    for idx in summits:
        if dist[idx] < answer[1]:
            answer = [idx, dist[idx]]
            
    return answer
