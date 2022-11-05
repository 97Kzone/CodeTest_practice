for t in range(1, int(input())+1):
    N, M = map(int, input().split())
    
    bnum = format(M, 'b')
    res = "ON" if bnum[-N:].count('1') == N else "OFF"
    
    print("#{} {}".format(t, res))