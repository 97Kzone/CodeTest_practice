from collections import defaultdict
import sys

N, M = map(int, input().split())
nums = [list(map(int, sys.stdin.readline().split())) for _ in range(M)]

dict = defaultdict(list)
visit = [False for _ in range(N)]

for a, b in nums:
    dict[a].append(b)
    dict[b].append(a)

res = False
def check(depth, idx):
    global res
    if depth == 4:
        res = True
        return 
    
    for val in dict[idx]:
        if not visit[val]:
            visit[val] = True
            check(depth + 1, val)
            visit[val] = False

for i in range(N):
    visit[i] = True
    check(0, i)
    visit[i] = False

    if res:
        break

if res:
    print(1)
else:
    print(0)