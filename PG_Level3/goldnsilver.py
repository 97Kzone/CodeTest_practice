#다른 사람의 풀이를 참고
def solution(a, b, g, s, w, t):
    res = 10 ** 17
    i, j = 0, (10**9) * (10**5) * 4
    
    while i <= j:
        m = (i + j) // 2
        go, si, to = 0, 0, 0
        
        for ng, ns, nw, nt in zip(g, s, w, t):
            tmp = m // (nt * 2)
            move = tmp + 1 if m % (nt * 2) >= nt else tmp     
            
            std = move * nw
            go += ng if ng < std else std 
            si += ns if ns < std else std
            to += ng + ns if ng + ns < std else std
        
        if go >= a and si >= b and to >= a+b:
            j = m-1
            res = min(res, m)
        else:
            i = m+1
            
    return res