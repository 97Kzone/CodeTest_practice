import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

def find(x):
    if x != p[x]:
        p[x] = find(p[x])
    return p[x]

def union(a, b):
    a = find(a)
    b = find(b)

    if a < b:
        p[b] = a
    else:
        p[a] = b

N = int(input())
M = int(input())
board = [list(map(int, input().split())) for _ in range(N)]
p = [i for i in range(N)]
plan = list(map(int, input().split()))

for i in range(N):
    for j in range(N):
        if board[i][j] == 1:
            union(i, j)

p = [-1] + p
s = p[plan[0]]
for i in range(1, M):
    if p[plan[i]] != s:
        print("NO")
        exit()

print("YES") 
