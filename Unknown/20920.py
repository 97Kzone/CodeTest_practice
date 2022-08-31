import sys
from collections import defaultdict
input = sys.stdin.readline

N, M = map(int, input().split())
d = defaultdict(int)

for _ in range(N):
    word = input().rstrip()
    if len(word) < M:
        continue

    d[word] += 1

d = dict(sorted(d.items()))
d = dict(sorted(d.items(), key = lambda x : -len(x[0])))
d = dict(sorted(d.items(), key = lambda x : -x[1]))

for k in d.keys():
    print(k)