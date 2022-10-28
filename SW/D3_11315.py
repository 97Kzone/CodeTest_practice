for t in range(1, int(input())+1):
    N = int(input())

    board = [list(input().rstrip()) for _ in range(N)]

    flag = False
    for i in range(N):
        for j in range(N):
            if board[i][j] == "o":
                #가로
                if board[i][j:j+5].count("o") == 5:
                    flag = True

                #세로
                for k in range(1, 5):
                    if i+k < N:
                        if board[i+k][j] != "o":
                            break
                    else:
                        break
                else:
                    flag = True

                #우하 대각선
                for k in range(1, 5):
                    if i+k < N and j+k < N:
                        if board[i+k][j+k] != "o":
                            break
                    else:
                        break
                else:
                    flag = True

                #좌하 대각선
                for k in range(1, 5):
                    if i+k < N and j-k >= 0:
                        if board[i+k][j-k] != "o":
                            break
                    else:
                        break
                else:
                    flag = True

            if flag:
                break
    
    res = "YES" if flag else "NO"
    print("#{} {}".format(t, res))