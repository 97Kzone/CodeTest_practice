import sys
from collections import defaultdict
input = sys.stdin.readline

N = int(input())
check = defaultdict(int)
plan = [[list(input().split()) for _ in range(4)] for _ in range(N)]
time = [4, 6, 4, 10]

for week in plan:
    for i, v in enumerate(week):
        for name in v:
            if name == "-":
                continue
            
            check[name] += time[i]

if check:
    print("Yes" if (max(check.values()) - min(check.values())) <= 12 else "No")
else:
    print("Yes")
