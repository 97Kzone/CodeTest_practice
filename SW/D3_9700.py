for t in range(1, int(input())+1):
    p, q = map(float, input().split())
    res = "YES" if (1-p)*q < (1-q)*p*q else "NO"

    print("#{} {}".format(t, res))
