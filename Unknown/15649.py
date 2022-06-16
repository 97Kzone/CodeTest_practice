from itertools import permutations as P

N, M = map(int, input().split())
Sets = [i for i in range(1, N+1)]

temps = P(Sets, M)

for temp in temps:
    temp = list(map(str, temp))
    print(" ".join(temp))