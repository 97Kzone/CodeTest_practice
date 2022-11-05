for t in range(1, int(input())+1):
    a, b = map(int, input().split())
    
    if a < 10 and b < 10:
        res = a * b
    else:
        res = -1
        
    print("#{} {}".format(t, res))