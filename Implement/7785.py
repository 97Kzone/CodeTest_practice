import sys
input = sys.stdin.readline

N = int(input())
dic = dict()
for _ in range(N):
    n, c = input().rstrip().split()

    if c == "enter":
        dic[n] = 1
    else:
        dic[n] = 0

res = []
for k, v in dic.items():
    if v == 1:
        res.append(k)

sorted(k, reverse=True)
for v in res:
    print(v)
