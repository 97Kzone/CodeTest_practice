for t in range(1, 11):
    N = int(input())

    board = [list(input()) for _ in range(8)]
    
    res = 0
    std = N//2 if N%2 == 0 else (N//2)+1
    for row in board:
        for i in range(8-N+1):
            if row[i:i+std] == row[i+N-1:i+N-1-std:-1]:
                res += 1
    
    #행열 뒤집기
    for row in zip(*board):
        for i in range(8-N+1):
            if row[i:i+std] == row[i+N-1:i+N-1-std:-1]:
                res += 1
    
    print("#{} {}".format(t, res))