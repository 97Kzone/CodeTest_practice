from itertools import permutations as pm

def solution(k, dungeons):
    res = -1
    for t in list(pm(dungeons, len(dungeons))):
        cnt = 0
        p = k
        for q, v in t:
            if p >= q:
                p -= v
                cnt += 1
        
        res = max(res, cnt)
    
    return res