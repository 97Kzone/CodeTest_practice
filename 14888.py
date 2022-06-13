from cmath import inf
from itertools import permutations as pm

N = int(input())
nums = list(map(int, input().split()))
oper = list(map(int, input().split()))

temp = []
for idx, val in enumerate(oper):
    if idx == 0:
        c = "+"
    elif idx == 1:
        c = "-"
    elif idx == 2:
        c = "*"
    elif idx == 3:
        c = "/"
    
    for _ in range(val):
        temp.append(c)

std = list(set(pm(temp, N-1)))
M, m = -inf, inf

for val in std:
    res = nums[0]
    for i in range(1, N):
        if val[i-1] == "+":
            res += nums[i]
        elif val[i-1] == "-":
            res -= nums[i]
        elif val[i-1] == "*" :
            res *= nums[i]
        elif val[i-1] == "/":
            if res < 0:
                res = -(abs(res) // nums[i])
            else:
                res //= nums[i]
    M = max(M, res)
    m = min(m, res)

print(M, m)
    


