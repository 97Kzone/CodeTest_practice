std = ["NA", "MMYY", "YYMM", "AMBIGUOUS"]
for t in range(1, int(input())+1):
    N = list(input())
    a, b = int("".join(N[:2])), int("".join(N[2:]))

    res = 0
    #MMYY
    if 1 < a < 13:
        res += 1
    
    #YYMM
    if 1 < b < 13:
        res += 2
    
    print("#{} {}".format(t, std[res]))


    
    