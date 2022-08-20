import sys
from collections import defaultdict
input = sys.stdin.readline

N = int(input())
words = list(input().rstrip())

i = 0
d = defaultdict(int)
res = 0

for j in range(len(words)):
    d[words[j]] += 1
    print(d)
    while len(d) > N:
        d[words[i]] -= 1
        if d[words[i]] == 0:
            del d[words[i]]
        i += 1
    res = max(res, j-i+1)

print(res)
