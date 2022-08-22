import sys
from collections import defaultdict
input = sys.stdin.readline

N, M = map(int, input().split())
words = defaultdict(int)
for _ in range(N):
    words[input().rstrip()] = 1

blogs = [list(input().rstrip().split(",")) for _ in range(M)]

for blog in blogs:
    for word in blog:
        if word in words:
            words[word] -= 1
            if words[word] == 0:
                del words[word]

    print(len(words))
