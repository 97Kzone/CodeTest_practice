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
    if S[i] == 3 * t:
        res[3] += res[2]
    
    if S[i] == 2 * t:
        res[2] += res[1]
    
    if S[i] == t:
        res[1] += res[0]
    
print(res[-1])