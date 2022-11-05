for t in range(1, int(input())+1):
    n, m = map(int, input().split())
    
    fee = [int(input()) for _ in range(n)]
    cars = [0] + [int(input()) for _ in range(m)]

    now, cnt, wait = [0] * n, 0, []
    res = 0
    for _ in range(2*m):
        N = int(input())

        #주차하러 왔다면
        if N > 0:
            #주차 자리가 없으면 wait
            if cnt == n:
                wait.append(N)
            else:
                #제일 앞 번호로 배정
                idx = now.index(0)
                now[idx] = N
                cnt += 1

        else:
            idx = now.index(-N)
            now[idx] = 0
            cnt -= 1

            res += fee[idx] * cars[-N]

            #대기 차량 있으면 주차해주자
            if wait:
                w = wait.pop(0)
                now[idx] = w
                cnt += 1

    print("#{} {}".format(t, res))

    