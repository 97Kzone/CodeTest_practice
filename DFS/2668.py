import sys
from collections import defaultdict
input = sys.stdin.readline

def DFS(i):
    if check[dic[i]] == 0:
        w1.add(i)
        w2.add(dic[i])
        check[dic[i]] = 1

        DFS(dic[i])

N = int(input())
dic = defaultdict(int)
check = [0] * (N+1)
for i in range(1, N+1):
    dic[i] = int(input())

res = []
for i in range(1, N+1):
    w1, w2 = set(), set()
    DFS(i)

    if w1 == w2:
        for v in w1:
            res.append(v)    
    else:
        for v in w2:
            check[v] = 0

res.sort()
print(len(res))
for v in res:
    print(v)