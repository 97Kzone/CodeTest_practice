import sys

A, B = input().split()
m = sum(map(int, (A.replace("6", "5"), B.replace("6", "5"))))
M = sum(map(int, (A.replace("5", "6"), B.replace("5", "6"))))

print(m, M)

#solved 2021-12-28