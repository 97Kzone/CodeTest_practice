for i in range(1, int(input()) + 1):
    idx = 10
    s = input().rstrip()
    res = 0
    while idx >= 1:
        tmp = s[:idx]
        if tmp == s[idx:2*idx]:
            res = idx
        idx -= 1
    print("#{} {}".format(i, res))