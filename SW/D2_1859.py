for t in range(1, int(input())+1):
    N = int(input())
    std = list(map(int, input().split()))
    
    res, v = 0, std[-1]
    for i in range(N-1, -1, -1):
        if v > std[i]:
            res += v-std[i]
        else:
            v = std[i]
            
    print("#{} {}".format(t, res))