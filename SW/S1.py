for t in range(1, int(input())+1):
    M, N = map(int, input().split())
    robots = []

    res, l, r = 0, 301, 0
    for _ in range(N):
        x, y = map(int, input().split())
        res = max(x, res)
        l = min(l, y)
        r = max(r, y)
            
    res -= 1

    # U가 선행, 양 끝의 위치를 기준으로 L, R 판단
    if l-1 >= M-r:
        res += M-l
    else:
        res += r-1
        
    print("#{} {}".format(t, res))