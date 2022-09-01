from itertools import product as pd
for _ in range(int(input())):
    op = [" ", "+", "-"]
    N = int(input())

    nums = [str(i) for i in range(1, N+1)]
    std = list(pd(op, repeat=N-1))
    
    for oper in std:
        s = ""
        for i in range(N-1):
            s += nums[i] + oper[i]
        
        s += nums[-1]

        if eval(s.replace(" ", "")) == 0:
            print(s)
    
    print()
