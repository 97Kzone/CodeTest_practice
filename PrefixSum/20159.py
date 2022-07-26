import sys
input = sys.stdin.readline

N = int(input())
cards = [0] + list(map(int, input().split()))
v1, v2 = [0], [0]

for i in range(1, N+1):
    if i % 2:
        v1.append(v1[-1] + cards[i])
        v2.append(v2[-1])
    else:
        v1.append(v1[-1])
        v2.append(v2[-1] + cards[i])

res = v1[-1]
for i in range(1, N+1):
    if i % 2:
        res = max(res, v1[i-1] + v2[-1] - v2[i])
    else:
        res = max(res, v1[i] + v2[-2] - v2[i-1])
        
print(res)
