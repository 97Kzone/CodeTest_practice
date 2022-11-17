for t in range(1, 11):
    N = int(input())

    board = [list(input()) for _ in range(N)]

    res = 0
    for row in zip(*board):
        s = "".join(row)
        s = s.replace("0", "")

        res += s.count("12")

    print("#{} {}".format(t, res))
