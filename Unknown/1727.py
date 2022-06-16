import sys, heapq as hq

N, M = map(int, input().split())
boys = list(map(int, sys.stdin.readline().split()))
girls = list(map(int, sys.stdin.readline().split()))

hq.heapify(boys)
hq.heapify(girls)

res = 0
while N != 0 and M != 0:
    boy = hq.heappop(boys)
    girl = hq.heappop(girls)

    print(boy, girl)
    
    res += abs(boy - girl)
    N -= 1
    M -= 1

print(res)
