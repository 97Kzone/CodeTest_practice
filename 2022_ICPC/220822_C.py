import sys
input = sys.stdin.readline

P, N = map(int, input().split())
items = list(map(int, input().split()))
items.sort()

res = 0
for item in items:
    if P >= 200:
        break

    if P + item >= 200:
        res += 1
        break
    else:
        res += 1
        P += item

print(res)

# 통과