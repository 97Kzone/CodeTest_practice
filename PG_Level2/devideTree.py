from collections import defaultdict

def solution(n, wires):
    res = 10e9
    d = defaultdict(list)
    
    def DFS(idx, check):
        check.add(idx)
        
        for node in d[idx]:
            if node not in check:
                check = DFS(node, check)
        
        return check
    
    for s, e  in wires:
        d[s].append(e)
        d[e].append(s)
    
    for i in range(1, n+1):
        for node in d[i]:
            check = set()
            check.add(i)
            check = DFS(node, check)
            v = abs((n-(len(check)-1)) - (len(check)-1))
            
            res = min(res, v)
            
    return res