## 이분탐색 문제인데 해쉬로 풀이 ...
import sys
from collections import defaultdict

input = sys.stdin.readline

N = int(input())
cards = defaultdict(int)

temp = list(input().split())

for val in temp:
    cards[val] += 1

M = int(input())
temp = list(input().split())

res = []
for val in temp:
    res.append(cards[val])

print(" ".join(str(v) for v in res))
