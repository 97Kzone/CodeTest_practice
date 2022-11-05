for t in range(1, int(input())+1):
    N = int(input())

    res = 0
    for _ in range(N):
        p, x = input().split()
        res += float(p)*int(x)
    
    print("#{} {:.6f}".format(t, round(res, 6)))