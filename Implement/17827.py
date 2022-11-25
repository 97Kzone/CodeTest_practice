import sys
input = sys.stdin.readline

N, M, V = map(int, input().split())
nodes = list(map(int, input().split()))
cycle = nodes[V-1:]
l = N-V+1

res = []
for _ in range(M):
    K = int(input())

    if K < N:
        res.append(nodes[K])
    else:
        res.append(cycle[(K-V+1)%l])
    
for v in res:
    print(v)