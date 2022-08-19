import sys
input = sys.stdin.readline

N = int(input())
std = list(map(int, input().split()))
std.sort()

i, j = 0, N-1
s = 10e9
res = [0, 0]
while i < j:
    v = std[i] + std[j]

    if abs(v) < s:
        s = abs(v)
        res = [std[i], std[j]]

    if v < 0:
        i += 1
    else:
        j -= 1
        
print(*res)


