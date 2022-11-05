for t in range(1, int(input())+1):
    N = int(input())
    N -= 1
    while N >= 0:
        if N % 2 == 1:
            N = (N-1)//2
        
        if N % 4 == 0:
            res = 0
            break
        elif N % 2 == 0:
            res = 1
            break
    
    print("#{} {}".format(t, res))