for t in range(1, int(input())+1):
    N = int(input())
    g = []

    res = 0
    for i in range(N):
        s, e = map(int, input().split())

        for a, b in g:
            if (s > a and e < b) or (s < a and e > b):
                res += 1
        
        g.append((s, e))
    
    print("#{} {}".format(t, res))