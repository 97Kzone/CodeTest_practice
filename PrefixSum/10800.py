import sys
from collections import defaultdict
input = sys.stdin.readline

N = int(input())
balls = [list(map(int, input().split())) + [i] for i in range(N)]
balls.sort(key = lambda x : x[1])

color = defaultdict(int)
res = defaultdict(int)
s = 0
idx = 0
for i in range(N):
    while balls[idx][1] < balls[i][1]:
        s += balls[idx][1]
        color[balls[idx][0]] += balls[idx][1]
        idx += 1
    res[balls[i][2]] = s - color[balls[i][0]]

for i in range(N):
    print(res[i])

