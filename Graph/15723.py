import sys
from collections import defaultdict
input = sys.stdin.readline

N = int(input())
dic = defaultdict()

for _ in range(N):
    a, b, c = input().split()
    dic[a] = c

for _ in range(int(input())):
    a, b, c = input().split()

    while a in dic:
        if dic[a] == c:
            print("T")
            break
        else:
            a = dic[a]
    else:
        print("F")
    