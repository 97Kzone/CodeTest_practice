import sys

N = int(input())
temp = [int(input()) for _ in range(N)]

for num in temp:
    res = []
    div, mod = divmod(num, 25)
    res.append(div)
    div, mod = divmod(mod, 10)
    res.append(div)
    div, mod = divmod(mod, 5)
    res.append(div)
    res.append(mod)
    print(res[0], res[1], res[2], res[3])

#직관적이나 불필요한 메모리 사용
#solved 2021-12-28 