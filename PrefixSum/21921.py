import sys
from itertools import accumulate as ac
input = sys.stdin.readline

N, X = map(int, input().split())
days = list(map(int, input().split()))
cnt = [0] + list(ac(days))

res =  [0, 0]
for i in range(X, N+1):
    if cnt[i] - cnt[i-X] > res[0]:
        res = [cnt[i] - cnt[i-X], 1] 
    elif cnt[i] - cnt[i-X] == res[0]:
        res[1] += 1

if res[0] != 0:
    print(res[0])
    print(res[1])
else:
    print("SAD")