import sys
from itertools import product as pd
input = sys.stdin.readline

for _ in range(int(input())):
    x, y, z = map(int, input().split())

    n1 = [i for i in range(1, x+1)]
    n2 = [i for i in range(1, y+1)]
    n3 = [i for i in range(1, z+1)]

    n = [n1, n2, n3]
    t = list(pd(*n))

    res = 0
    for v in t:
        a, b, c = v
        if a % b == b % c == c % a:
            res += 1
    
    print(res)

# 통과