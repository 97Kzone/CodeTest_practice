for t in range(1, int(input())+1):
    N = int(input())
    board = [list(map(int, list(input()))) for _ in range(N)]

    res = 0
    v = N//2
    #반 나누자
    for i in range(v+1):
        res += sum(board[i][v-i:v+1+i])

    for i in range(v+1, N):

        res += sum(board[i][i-v:v+N-i])
    
    print("#{} {}".format(t, res))