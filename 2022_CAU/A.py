n, m = map(int, input().split())
a, b = 100 - n, 100 - m
c, d = 100 - (a + b), a * b
q, r = divmod(d, 100)

print(a, b, c, d, q, r)
print(c+q, r)