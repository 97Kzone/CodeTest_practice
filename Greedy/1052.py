N, K = map(int, input().split())

res = 0
while bin(N).count("1") > K:
    i = bin(N)[::-1].index("1")
    res += 2 ** i
    N += 2 ** i

print(res)