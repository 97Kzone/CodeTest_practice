N = int(input())
a, b, c = map(int, input().split())

res = min(a, N) + min(b, N) + min(c, N)
print(res)