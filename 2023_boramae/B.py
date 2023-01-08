import sys
from collections import defaultdict

input = sys.stdin.readline

N = int(input())
dic = defaultdict(int)

res = 0
for _ in range(N):
    s, e = map(int, input().split())
    if e == 1:
        if dic[s] == 1:
            res += 1
        dic[s] = 1
    else:
        if dic[s] == 0:
            res += 1
        dic[s] = 0

print(res + sum(dic.values()))