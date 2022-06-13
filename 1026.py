import sys

N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

res = 0
L = len(A)
while A:
    a, b = min(A), max(B)
    res += a * b
    A.remove(a)
    B.remove(b)
    
print(res)
