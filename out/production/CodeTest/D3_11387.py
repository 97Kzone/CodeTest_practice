for t in range(1, int(input())+1):
    D, L, N = map(int, input().split())

    res = 0
    for i in range(0, N):
        res += D* (1+(i*(L/100)))
    
    print("#{} {}".format(t, int(res)))