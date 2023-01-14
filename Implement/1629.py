def check(a, b, c):
    if b == 1:
        return a%c
    else:
        v = check(a, b//2, c)
        if b % 2 == 0:
            return (v*v)%c
        else:
            return ((v*v)*a)%c

A, B, C = map(int, input().split())
res = check(A, B, C)
print(res)