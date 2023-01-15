for t in range(1, int(input())+1):
    N = int(input())
    res, speed = 0, 0

    for _ in range(N):
        v = list(map(int, input().split()))
        if v[0] == 0:
            res += speed
        elif v[0] == 1:
            speed += v[1]
            res += speed
        else:
            speed = speed-v[1] if speed > v[1] else 0
            res += speed
        
    print("#{} {}".format(t, res))