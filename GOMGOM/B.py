from collections import defaultdict
import sys
input = sys.stdin.readline

N = int(input())
check = defaultdict(int)
check["ChongChong"] = 1

for _ in range(N):
    a, b = input().split()

    if check[a] + check[b] > 0:
        check[a] = 1
        check[b] = 1

res = 0
for v in check.values():
    res += v

print(res)