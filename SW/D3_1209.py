for t in range(1, 2):
    N = int(input())

    board = [list(map(int, input().split())) for _ in range(100)]
    r, c, d1, d2 = 0, 0, 0, 0

    for i in range(100):
        for j in range(100):
            if i == j:
                d1 += board[i][j]
            
            if i+j == 100:
                d2 += board[i][j]
            
    for row in board:
        r = max(r, sum(row))

    for row in zip(*board):
        c = max(c, sum(row))

    print("#{} {}".format(t, max(r, c, d1, d2)))
