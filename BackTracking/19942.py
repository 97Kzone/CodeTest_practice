import sys
from itertools import combinations as cb
input = sys.stdin.readline

N = int(input())
mp, mf, ms, mv = map(int, input().split())

items = [list(map(int, input().split())) for _ in range(N)]
nums = [i for i in range(N)]

res, std = 10**9, []
for i in range(1, N+1):
    for v in cb(nums, i):
        sp, sf, ss, sv, scost = 0, 0, 0, 0, 0
        for k in v:
            sp += items[k][0] 
            sf += items[k][1]
            ss += items[k][2]
            sv += items[k][3]
            scost += items[k][4]
        
        if sp >= mp and sf >= mf and ss >= ms and sv >= mv:
            if scost == res:
                std.append(list(v))
            elif scost < res:
                res = scost
                std = []
                std.append(list(v))

if len(std) == 0:
    print(-1)
    exit()
else:
    tmp = []
    std.sort()
    for v in std[0]:
        tmp.append(v+1)
    print(res)
    print(*tmp)