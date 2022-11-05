for t in range(1, int(input())+1):
    n, d, g = map(int, input().split())

    if d != 0 and g == 0:
        res = "Broken"
    elif d != 100 and g == 100:
        res = "Broken"
    else:
        for i in range(1, n+1):
            if ((i*d)/100) % 1 == 0:
                res = "Possible"
                break
        else:
            res = "Broken"
            
    print("#{} {}".format(t, res))    
