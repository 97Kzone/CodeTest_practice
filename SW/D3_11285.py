import math

answer = []
for t in range(1, int(input())+1):
    N = int(input())
    hits = [list(map(int, input().split())) for _ in range(N)]
    res = 0

    for x, y in hits:
        v = math.ceil(math.sqrt(x**2 + y**2) / 20)
        if v == 0:
            res += 10
        elif v <= 11:
            res += 11 - v
            
    answer.append(res)

for i in range(1, t+1):
    print("#{} {}".format(i, answer[i-1]))
