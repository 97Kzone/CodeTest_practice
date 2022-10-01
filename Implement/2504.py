import sys
input = sys.stdin.readline

std = list(input().rstrip())
stack = []

res, tmp = 0, 1
for i, v in enumerate(std):
    if v == "(":
        stack.append(v)
        tmp *= 2
    elif v == "[":
        stack.append(v)
        tmp *= 3
    elif  v == ")":
        if not stack or stack[-1] == "[":
            res = 0
            break
        
        if std[i-1] == "(":
            res += tmp
        stack.pop()          
        tmp //= 2
    else:
        if not stack or stack[-1] == "(":
            res = 0
            break
        
        if std[i-1] == "[":
            res += tmp   
        stack.pop()
        tmp //= 3

if stack:
    print(0)
else:
    print(res)