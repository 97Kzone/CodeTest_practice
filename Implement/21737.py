from collections import deque
N = int(input())
comm = list(input())
std = {"S" :"-", "U": "//", "M": "*", "P": "+", "C": "."}

def check(n1, n2, op):
    if op == "-":
        return n1 - n2
    elif op == "+":
        return n1 + n2
    elif op == "*":
        return n1 * n2
    elif op == "//":
        if n1 < 0:
            n1 *= -1
            n1 //= n2
            n1 *= -1
        else:
            n1 //= n2

        return n1
        
nums = deque()
tmp = ""
for c in comm:
    if c in std:
        if tmp:
            nums.append(int(tmp))
            tmp = ""
        nums.append(c)
    else:
        tmp += c


res = []
if "C" not in nums:
    print("NO OUTPUT")
else:
    while N > 0:
        n1 = nums.popleft()
        op = nums.popleft()

        N -= 1
        while op == "C":
            res.append(n1)
            if N <= 0:
                break
            op = nums.popleft()
            N -= 1
        if N <= 0:
            break
        
        n2 = nums.popleft()
        v = check(n1, n2, std[op])
        nums.appendleft(v)

    print(*res)