import sys
input = sys.stdin.readline

dic = {"0":0, "1":1}

i, j = 0, 1
for k in range(2, 100001):
    v = str(i+j)[-21:]
    dic[v] = k
    i = j
    j = int(v)

for _ in range(int(input())):
    N = input().rstrip()[-21:]
    print(dic[N])

