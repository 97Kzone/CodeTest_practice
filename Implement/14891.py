import sys
from collections import deque
input = sys.stdin.readline

std = [[]]
for _ in range(4):
    tmp = deque(input().rstrip())
    std.append(tmp)

def check_r(idx, a):
    if idx > 4 or std[idx-1][2] == std[idx][6]:
        return
    
    if std[idx-1][2] != std[idx][6]:
        check_r(idx+1, -a)
        std[idx].rotate(a)

def check_l(idx, a):
    if idx < 1 or std[idx][2] == std[idx+1][6]:
        return
    
    if std[idx][2] != std[idx+1][6]:
        check_l(idx-1, -a)
        std[idx].rotate(a)

for _ in range(int(input().rstrip())):
    idx, a = map(int, input().split())
    check_l(idx-1, -a)
    check_r(idx+1, -a)
    std[idx].rotate(a)

res = 0
for i in range(4):
    res += int(std[i+1][0]) * (2 ** i)

print(res)
