from cmath import inf
import sys
from itertools import accumulate
input = sys.stdin.readline

N = int(input())
trees = [[0] + list(map(int, input().split())) for _ in range(N)]
trees.insert(0, [0] * (N+1))

for i, tree in enumerate(trees):
    trees[i] = list(accumulate(tree))
    
for i, tree in enumerate(list(zip(*trees))):
    trees[i] = list(accumulate(tree))

trees = list(zip(*trees))

res = -inf
for i in range(N):
    for j in range(1, N-i+1):
        for k in range(1, N-i+1):
            v = trees[i+j][i+k] - trees[j-1][i+k] - trees[i+j][k-1] + trees[j-1][k-1]
            res = max(res, v)
            
print(res)