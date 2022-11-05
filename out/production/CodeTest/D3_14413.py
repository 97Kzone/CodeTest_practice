for t in range(1, int(input()) + 1):
    n, m = map(int, input().split())
    board = [list(input().rstrip()) for _ in range(n)]
    check = [0, 0, 0, 0]
    
    for i in range(n):
        for j in range(m):
            if board[i][j] == "#":
                if (i + j) % 2 == 0:
                    check[0] += 1
                else:
                    check[1] += 1
            if board[i][j] == ".":
                if (i+ j) % 2 == 0:
                    check[2] += 1
                else:
                    check[3] += 1
    
    res = "impossible" if (check[0] and check[1]) or (check[0] and check[2]) or (check[2] and check[3]) or (check[1] and check[3]) else "possible"
    print("#{} {}".format(t, res))
			
           		