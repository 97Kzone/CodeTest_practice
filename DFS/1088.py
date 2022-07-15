from cmath import inf
import sys
input = sys.stdin.readline

def DFS(n, p):
    p[n] = -inf
    for i in range(len(p)):
        if n == p[i]:
            DFS(i, p)

N = int(input())
p = list(map(int, input().split()))
rm = int(input())

cnt = 0
DFS(rm, p)

for i in range(len(p)):
    if p[i] != -inf and i not in p:
        cnt += 1

print(cnt)