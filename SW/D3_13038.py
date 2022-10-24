for t in range(1, int(input())+1):
    n = int(input())
    days = list(map(int, input().split()))

    res = 10**6

    for i in range(7):
        if days[i] == 1:
            s, cnt = i, 0

            while True:
                if days[s%7] == 1:
                    cnt += 1
                
                s += 1
                if cnt == n:
                    res = min(res, s-i)
                    break

        
    print("#{} {}".format(t, res))