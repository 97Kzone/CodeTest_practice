import sys
input = sys.stdin.readline

D, K = map(int, input().split())

x, y = 1, 1
for _ in range(3, D):
    x, y = y, x + y

print(x, y)

r1, r2 = 0, 0
for i in range(1, 100000):
    tmp = K - (i * x)

    if tmp < 0:
        break

    if tmp % y == 0:
        r2 = tmp // y
        r1 = i
        break
    
print(r1)
print(r2)
    