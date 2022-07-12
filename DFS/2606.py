import sys
from collections import defaultdict

input = sys.stdin.readline

def DFS(v):
    global res
    check[v] = 1
    res.append(v)
    
    for i in range(1, N+1):
        if check[i] == 0 and i in dic[v]:
            DFS(i)

    return

N = int(input())
dic = defaultdict(list)

for _ in range(int(input())):
    a, b = map(int, input().split())
    dic[a].append(b)
    dic[b].append(a)

check = [0] * (N+1)
res = []
DFS(1)

print(len(res)-1)
