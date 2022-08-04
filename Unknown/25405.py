import sys, heapq as hq
input = sys.stdin.readline

N = int(input())
levels = []

for level in list(map(int, input().split())):
    hq.heappush(levels, level)

M, K = map(int, input().split())

for _ in range(M):
    tmp = []
    for _ in range(K):
        tmp.append(hq.heappop(levels))
    
    for v in tmp:
        v += 1
        hq.heappush(levels, v)

res = ""
while levels:
    res += str(hq.heappop(levels)) + " "

print(res.rstrip(" "))