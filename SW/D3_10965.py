from collections import Counter
answer = []

def check(n):
    v = 2
    res = []
    while v**2 <= n:
        while (n % v == 0):
            res.append(v)
            n //= v
        v += 1

    if n > 1:
        res.append(n)

    return res

for t in range(1, int(input())+1):
    N = int(input())
    res = 1    
    
    if N != 1:
        std = check(N)
        for k, v in Counter(std).items():
            if v % 2 == 1:
                res *= k

    answer.append(res)

for i in range(1, t+1):
    print("#{} {}".format(i, answer[i-1]))
