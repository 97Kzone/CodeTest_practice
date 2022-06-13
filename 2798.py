from itertools import combinations as cb
import sys
N, M = map(int, input().split())

cards = list(map(int, sys.stdin.readline().split()))

datas = cb(cards, 3)

std = 0

for data in datas:
    val = sum(list(data))
    if val <= M and val > std:
        std = val

print(std)

# 브루트포스 연습
