for t in range(1, int(input())+1):
    N = int(input())
    std, cnt = "", 0
    for _ in range(N):
        s, e = input().split()
        cnt += int(e)
        std += s * int(e)
    
    print("#{}".format(t))
    for i in range(0, cnt, 10):
        print(std[i:i+10])
    