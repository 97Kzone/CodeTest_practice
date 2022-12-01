import sys
input = sys.stdin.readline

def isPrime():
    n = int(10000**0.5)
    v = [True] * 10001
    for i in range(2, n+1):
        if v[i]:
            for j in range(i+i, 10001, i):
                v[j] = False
            
    return [i for i in range(2, 10001) if v[i]]

check = isPrime()
for _ in range(int(input())):
    t, num = map(int, input().split())
    N = num
    if num in check:
        visit = set()
        while True:
            tmp = 0
            while N > 0:
                d, v = divmod(N, 10)
                tmp += v**2
                N = d 
            
            if tmp == 1:
                print("{} {} YES".format(t, num))
                break
            
            if tmp in visit:
                print("{} {} NO".format(t, num))
                break

            visit.add(tmp)
            N = tmp
    else:
        print("{} {} NO".format(t, num))
