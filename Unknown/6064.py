T = int(input())

for _ in range(T):
    M, N, x, y = map(int, input().split())

    res = 1
    while res < M**2:
        div1, mod1 = divmod(res, M)
        div2, mod2 = divmod(res, N)

        if mod1 == 0: mod1 += div1
        if mod2 == 0: mod2 += div2

        if mod1 == x and mod2 == y:
            break
        res += 1

    else:
        res = -1

    print(res)