def check(i, j):
    global res
    tmp = 0
    for x in range(i, i+M):
        for y in range(j, j+M):
            tmp += board[x][y]
    
    res = max(res, tmp)

for t in range(1, int(input())+1):
    N, M = map(int, input().split())

    board = [list(map(int, input().split())) for _ in range(N)]
    res = 0
    
    for i in range(N-M+1):
        for j in range(N-M+1):
            check(i, j)
    
    print("#{} {}".format(t, res))
