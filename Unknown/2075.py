import sys, heapq as hq
input = sys.stdin.readline

N = int(input())
q = list(map(int, input().split()))

for _ in range(N-1):
    for v in list(map(int, input().split())):
        if q[0] < v:
            hq.heappush(q, v)
            hq.heappop(q)

print(q[0])