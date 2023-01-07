for t in range(1, int(input())+1):
    N = int(input())
    res = 0
    for i in range(1, N+1):
        res += -i if i%2 == 0 else i
    
    print("#{} {}".format(t, res))