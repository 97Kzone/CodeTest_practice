def solution(n, m, x, y, queries):
    mx, my, Mx, My = x, y, x, y
    
    for q, v in queries[::-1]:
        if q == 0:
            My += v
            My = m-1 if My > m-1 else My
            my = my+v if my != 0 else my
            
        elif q == 1:
            my -= v
            my = 0 if my < 0 else my
            My = My-v if My != m-1 else My
                
        elif q == 2:
            Mx += v
            Mx = n-1 if Mx > n-1 else Mx
            mx = mx+v if mx != 0 else mx
                
        elif q == 3:
            mx -= v
            mx = 0 if mx < 0 else mx
            Mx = Mx-v if Mx != n-1 else Mx
    
    if Mx < 0 or mx > n-1 or My < 0 or my > m-1:
        return 0
    else:
        return (Mx-mx+1) * (My-my+1)