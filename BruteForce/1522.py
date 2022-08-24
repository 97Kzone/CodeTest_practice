import sys
from collections import Counter as C
input = sys.stdin.readline

s = input().rstrip()
a = C(s)["a"]
s += s[:-1]

res = 10e9
for i in range(len(s)-a):
    res = min(res, C(s[i:i+a])["b"])

print(res if res != 10e9 else 0)
