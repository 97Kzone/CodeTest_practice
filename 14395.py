from collections import deque

S, T = map(int, input().split())
op = ["*", "+", "/"]
check = set()

check.add(S)

def bfs():
    q = deque()
    q.append([S, ""])
    
    while q:
        s, std = q.popleft()
        if s == T:
            print(std)
            return

        for i in range(3):
            if i == 0:
                ns = s * s
            elif i == 1:
                ns = s + s
            elif i == 2:
                ns = 1
            
            if 0 < ns <= T and not ns in check:
                check.add(ns)
                q.append([ns, std+op[i]])
    else:
        print(-1)
if S == T:
    print(0)
else:
    bfs()


