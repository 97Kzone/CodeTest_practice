from itertools import accumulate
import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))
S = list(accumulate(nums))
res = [1, 0, 0, 0]

if S[-1] % 4 != 0:
    print(0)
    exit()

t = S[-1] // 4 #target

for i in range(N-1):
    for j in range(1, 4):
        if S[i] == j * t:
            res[j] += res[j-1] 

print(res[-1])