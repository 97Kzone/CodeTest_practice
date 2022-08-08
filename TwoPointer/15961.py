from collections import defaultdict
import sys
input = sys.stdin.readline

N, D, K, C = map(int, input().split())
sushi = [int(input()) for _ in range(N)]
sushi += sushi[:K]

take = defaultdict(int)
take[C] = 1
for i in range(K):
    take[sushi[i]] += 1

res, i, j = 0, 0, K
while j < len(sushi):
    res = max(res, len(take))

    take[sushi[i]] -= 1
    if take[sushi[i]] == 0:
        del take[sushi[i]]
    
    take[sushi[j]] += 1
    i += 1
    j += 1

print(res)