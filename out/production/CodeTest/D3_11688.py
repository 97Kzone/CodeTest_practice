for t in range(1, int(input())+1):
    s = list(input().rstrip())

    a, b = 1, 1
    for v in s:
        if v == "L":
            b += a
        else:
            a += b

    print("#{} {} {}".format(t, a, b))