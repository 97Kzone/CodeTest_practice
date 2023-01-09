import sys, math
input = sys.stdin.readline

for _ in range(int(input())):
    a, b = map(int, input().split())

    while True:
        la, lb = math.floor(math.log2(a)), math.floor(math.log2(b))

        if la > lb:
            a //= 2
        elif lb > la:
            b //= 2
        else:
            break

    while a != b:
        a //= 2
        b //= 2
    
    print(a*10)