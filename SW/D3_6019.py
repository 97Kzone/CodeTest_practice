for T in range(1, int(input())+1):
    d, a, b, f = map(int, input().split())

    t = d / (a+b)
    print("#{} {:.10f}".format(T, round(t*f, 10)))