import sys

G = int(input())
P = int(input())
plane = [int(sys.stdin.readline()) for _ in range(P)]

def find(x):
    if parent[x] == x:
        return x
    parent[x] = find(parent[x])
    return parent[x]

def union(x, y):
    x = find(x)
    y = find(y)
    if x > y:
        parent[x] = y
    else:
        parent[y] = x

parent = {i:i for i in range(G+1)}
cnt = 0

for val in plane:
    x = find(val)
    if x == 0:
        break
    union(x, x-1)
    cnt += 1

print(cnt)

# O(N^2) 알고리즘 = 시간초과, input() 사용 = 시간초과
# 시간초과와의 씨름을 하는 문제, union-find 알고리즘 접근부터 시간초과 원인을 찾기까지 많은 시간이 들어갔다.
# 정답률 30프로, solved 2022-01-07