## 이분탐색 문제인데 해쉬로 풀이...
import sys
input = sys.stdin.readline

N = int(input())
cards = dict()

temp = list(input().split())

for val in temp:
    cards[val] = 1

M = int(input())

temp = list(input().split())

res = []
for val in temp:
    if val in cards:
        res.append("1")
    else:
        res.append("0")

print(" ".join(res))