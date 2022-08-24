import sys
from collections import defaultdict
input = sys.stdin.readline

for _ in range(int(input())):
    W = input().rstrip()
    K = int(input())
    res = [10e9, 0]

    dic = defaultdict(list)

    for i in range(len(W)):
        dic[W[i]].append(i)

    for k, v in dic.items():
        if len(dic[k]) >= K:
            for i in range(len(dic[k])-K+1):
                res = [min(res[0], v[i+K-1]-v[i]+1), max(res[1], v[i+K-1]-v[i]+1)]

    if res[0] != 10e9:
        print(*res)
    else:
        print(-1)
