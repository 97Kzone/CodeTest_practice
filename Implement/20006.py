import sys
from collections import defaultdict
input = sys.stdin.readline

N, M = map(int, input().split())
rooms = defaultdict(list)
player = defaultdict(list)

for _ in range(N):
    l, n = input().split()
    player[n] = int(l)

idx = 1
for n, l in player.items():
    for i, v in rooms.items():
        if len(v) == M:
            continue
            
        if player[v[0]]-10 <= l <= player[v[0]]+10:
            rooms[i].append(n)
            break
    else:
        rooms[idx].append(n)
        idx += 1

for k, v in rooms.items():
    print("Started!" if len(v) == M else "Waiting!")
    v = sorted(v)
    for n in v:
        print(player[n], n)
