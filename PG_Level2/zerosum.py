import sys
from collections import defaultdict
sys.setrecursionlimit(10**6)

def solution(a, edges):
    
    if sum(a) != 0:
        return -1
    
    global answer
    global s
    answer, s = 0, 0
    visit, d = set(), defaultdict(list)
    
    for u, v in edges:
        d[u].append(v)
        d[v].append(u)
    
    def DFS(i):
        global answer
        global s
        visit.add(i)
        now = a[i]
        
        for nx in d[i]:
            if nx not in visit:
                now += DFS(nx)
            
        answer += abs(now)    
        return now
    
    DFS(0)
    
    return answer