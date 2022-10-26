res = []
for t in range(1, int(input())+1):
    n, s = map(int, input().split())
    
    nd, sd = 33, 33
    for i in range(1, 32):
        if n < 2 ** i:
            nd = min(nd, i-1)
        
        if s < 2 ** i:
            sd = min(sd, i-1)
    
    if n == 1:
        res.append(0)
        continue
        
    s_std = ((2**sd) + (2**(sd+1)-1)) // 2
    n_std = ((2**nd) + (2**(nd+1)-1)) // 2
    
    if s == 1:
        res.append(nd)
        continue
    
    if s > s_std:
        res.append(nd+sd)
    else: 
        if n > n_std:
            res.append(nd+sd)
        else:
            res.append(nd+sd-1)
        
for i in range(1, len(res)+1):
    print("#{} {}".format(i, res[i-1]))