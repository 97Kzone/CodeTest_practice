import sys
from collections import defaultdict
sys.setrecursionlimit(10**9)

input = sys.stdin.readline

def DFS(i):
    for num in dic[i]:
        if num == 1:
            continue
        
        if check[num] == 0:
            check[num] = i
            DFS(num)
        
N = int(input())
dic = defaultdict(list)

for _ in range(N-1):
    a, b = map(int, input().split())
    dic[a].append(b)
    dic[b].append(a)

check = [0] * (N+1)
DFS(1)

for v in check[2:]:
    print(v)