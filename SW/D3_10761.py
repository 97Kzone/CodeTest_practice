def check(bi, oi, t):
    global s
    while B or O:
        v = int(s[1])-1
        if s[0] == "B":
            if v == bi:
                s = s[2:] 
                B.pop(0)
            else:
                bi += 1 if v > bi else -1
            
            if O:
                if oi < O[0]-1:
                    oi += 1
                elif oi > O[0]-1:
                    oi -= 1
        else:
            if v == oi:
                s = s[2:]
                O.pop(0)
            else:
                oi += 1 if v > oi else -1
            
            if B:
                if bi < B[0]-1:
                    bi += 1
                elif bi > B[0]-1:
                    bi -= 1
        
        t += 1
    return t

for t in range(1, int(input())+1):
    global s
    s = list(input().split())
    N = s.pop(0)

    B, O = [], []
    for i in range(0, len(s)-1, 2):
        if s[i] == "B":
            B.append(int(s[i+1]))
        else:
            O.append(int(s[i+1]))

    res = check(0, 0, 0)
    
    print("#{} {}".format(t, res))