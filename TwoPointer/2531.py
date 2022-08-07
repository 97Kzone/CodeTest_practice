import sys
input = sys.stdin.readline

N, D, K, C = map(int, input().split())
sushi = [int(input()) for _ in range(N)]
l, r = 0, 0
res = 0
while l < N:
    r = l + K
    dish = set()

    for i in range(l, r):
        i %= N
        dish.add(sushi[i])
    
    if C not in dish:
        dish.add(C)
    
    res = max(res, len(dish))
    l += 1

print(res)