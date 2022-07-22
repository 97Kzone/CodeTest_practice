import sys
from collections import defaultdict
input = sys.stdin.readline

N = int(input())
dic = defaultdict(int)

for num in list(map(int, input().split())):
    dic[num] = 1

M = int(input())
for num in list(map(int, input().split())):
    print(1 if num in dic else 0)

