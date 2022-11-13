for t in range(1, int(input())+1):
    s = input()
    s *= 4
    x, y = 0, 0
    dx, dy = 1, 0

    res = [0] * len(s)
    for i, c in enumerate(s):
        if c == "S":
            x += dx
            y += dy
        elif c == "L":
            dx, dy = -dy, dx
        elif c == "R":
            dx, dy = dy, -dx
        
        res[i] = x**2 + y**2

    v = "oo" if res[-1] else max(res)
    print("#{} {}".format(t, v))