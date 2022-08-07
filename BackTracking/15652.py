N, M = map(int, input().split())
s = []

def check(i):
    if len(s) == M:
        print(*s)
        return
    
    for i in range(i, N+1):
        s.append(i)
        check(i)
        s.pop()

check(1)