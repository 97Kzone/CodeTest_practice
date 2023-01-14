import sys
input = sys.stdin.readline

N = int(input())
x, y = [], []

for _ in range(N):
    s, e = map(int, input().split())
    x.append(s)
    y.append(e)

x.append(x[0])
y.append(y[0])

res = 0
for i in range(N):
    res += (x[i]*y[i+1])-(x[i+1]*y[i])

print(round(abs(res)/2, 1))