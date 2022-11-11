for t in range(1, int(input())+1):
    M, N = map(int, input().split())
    cnt = 0
    if M == 1 or N == 0:
        cnt = M
    elif M <= N:
        cnt = M*2
    elif M > N and M <= 2:
        cnt = M*2
    elif M > N and N == 1:
        cnt = M+N
    else:
        cnt = M

    print("#{} {}".format(t, cnt))