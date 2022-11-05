from itertools import combinations as cb

for t in range(1, int(input())+1):
    N = int(input())
    words = [input() for _ in range(N)]
    
    res = 0
    for i in range(1, N+1):
        for case in cb(words, i):
            tmp = "".join(case)
            v = set(tmp)
        
            if len(v) == 26:
                res += 1
    
    print("#{} {}".format(t, res))