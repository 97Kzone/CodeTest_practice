for t in range(1, int(input())+1):
    a, b, c, d = map(int, input().split())

    div, mod = divmod(b+d, 60)
    tmp = (a+c+div)%12
    h = 12 if tmp == 0 else tmp
    print("#{} {} {}".format(t, h, mod))