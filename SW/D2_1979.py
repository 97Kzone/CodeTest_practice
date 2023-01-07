def check(i):
    global res
    row = "".join(board[i]).split('0')
    for v in row:
        if len(v) == K:
            res += 1
            
for t in range(1, int(input())+1):
    N, K = map(int, input().split())
    board = [list(input().split()) for _ in range(N)]

    res = 0
    for i in range(N):
        check(i)
    
    board = list(zip(*board))
    for i in range(N):
        check(i)
    
    print("#{} {}".format(t, res))
