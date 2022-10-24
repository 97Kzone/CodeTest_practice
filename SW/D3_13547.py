for t in range(1, int(input())+1):
    s = list(input().rstrip())
    cnt = s[:15].count("x")

    res = "NO" if cnt >= 8 else "YES"
    print("#{} {}".format(t, res))