import sys
from collections import defaultdict
sys.setrecursionlimit(10**9)

input = sys.stdin.readline

def DFS(i):
    check[i] = 1

    for num in dic[i]:
        if check[num] == 0:
            DFS(num)
            check[i] += check[num]

N, R, Q = map(int, input().split())
dic = defaultdict(list)
check = [0] * (N+1)

for _ in range(N-1):
    a, b = map(int, input().split())
    dic[a].append(b)
    dic[b].append(a)

DFS(R)

for _ in range(Q):
    print(check[int(input())])