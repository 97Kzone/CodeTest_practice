import sys

N = int(input())
K = int(input())
if K >= N:
    print(0)
else:
    coords = list(map(int, input().split()))
    coords.sort()
    dis = []
    for i in range(N-1):
        dis.append((coords[i+1]-coords[i]))

    for _ in range(K-1):
        dis.remove(max(dis))

    print(sum(dis))