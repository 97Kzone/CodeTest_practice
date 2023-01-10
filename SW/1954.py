for t in range(1, int(input())+1):
    N = int(input())

    board = [[0]*N for _ in range(N)]
    r, c = 0, -1
    d, i = 1, 1
    while N > 0:
        for _ in range(N):
            c += d
            board[r][c] = i
            i += 1
        
        N -= 1
        for _ in range(N):
            r += d
            board[r][c] = i
            i += 1
        
        d *= -1
    
    print("#{}".format(t))
    for i in range(len(board)):
        print(*board[i])
