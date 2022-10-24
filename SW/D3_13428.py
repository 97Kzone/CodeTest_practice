from itertools import combinations as cb

for t in range(1, int(input())+1):
    num = list(input().rstrip())
    idx = [i for i in range(len(num))]
    m, M = int("".join(num)), int("".join(num))

    for i, j in cb(idx, 2):
        num[i], num[j] = num[j], num[i]

        if num[0] == "0":
            num[i], num[j] = num[j], num[i]
            continue
        
        v = int("".join(num))
        if v < m:
            m = v
        
        if v > M:
            M = v
        
        num[i], num[j] = num[j], num[i]
    
    print("#{} {} {}".format(t, m, M))
