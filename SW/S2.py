for t in range(1, int(input())+1):
    N, M = map(int, input().split())
    board = [0] + list(map(int, input().split()))

    s1, s2 = [], []
    res = 0
    for i in range(1, N+1):
        if board[i] == 1:
            if i <= M:
                s1.append(i)
            else:
                s2.append(i)

    #왼쪽 or 오른쪽에 보석이 1개 이하면 움직일 필요 없다
    if len(s1) < 2 or len(s2) < 2:
        print("#{} {}".format(t, res))


        
    


        


        
